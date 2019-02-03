package com.company.Agent.Monster;

import com.company.Agent.Agent;
import com.company.Agent.Monster.MonsterAI.MonsterAI;
import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.CaveExplorer;
import com.company.MonsterSpawnerAndHandler;
import com.company.Scenes.MainGameScene;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.scene.Node;

abstract public class Monster extends Agent {

    @Override
    public void walk(MOVE_DIR move_dir) {
        face(move_dir);
        super.walk(move_dir);
    }

    // Monster Ai decides the behaviour style of the monster
    private MonsterAI monsterAI;
    public void setMonsterAI(MonsterAI monsterAI) {
        this.monsterAI = monsterAI;
    }
    public MonsterAI getMonsterAI() {
        return monsterAI;
    }

    public void despawn(){
        sleep();
        MainGameScene.getBoard().getChildren().remove(this);
    }

    // The monster begins taking actions
    public void awaken(){
        getMonsterAI().start();
    }

    public void sleep(){
        getMonsterAI().stop();
    }


    // attacking methods
    private double attackDamage;
    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }
    public double getAttackDamage() {
        return attackDamage;
    }

    private boolean playerInRange(double range){
        return Math.abs(getTileX() - CaveExplorer.getPlayerCharacter().getTileX()) <= range && Math.abs(getTileY() - CaveExplorer.getPlayerCharacter().getTileY()) <= range;
    }

    private boolean attackInProgress = false; // prevents multiple attackAnimations in progress at once
    public void attemptAttack(){

        if(!playerInRange(1) || attackInProgress){
            return;
        }

        attackInProgress = true;

        AnimationTimer attack = new AnimationTimer() {

            int USE_PHASES[] = new int[]{10,30,50};
            int animationTime = 0;

            @Override
            public void handle(long now) {

                if(animationTime <= USE_PHASES[0]){
                    buildMeleeAttackAppearance(0);
                } else if(animationTime <= USE_PHASES[1]){
                   buildMeleeAttackAppearance(1);
                } else if(animationTime <= USE_PHASES[2]) {
                   buildMeleeAttackAppearance(2);
                    if(animationTime == USE_PHASES[2]){

                        // resets animation , permits another attack
                        buildDefaultAppearance();
                        animationTime = 0;
                        attackInProgress = false;
                        stop();

                        // damages player if still in range (range slightly increased)
                        if(playerInRange(2)){
                            double damageToDeal = getAttackDamage()/2 + Math.random()*(getAttackDamage());
                            CaveExplorer.getPlayerCharacter().takeDamage(damageToDeal);
                        }
                    }
                }
                animationTime++;
            }
        };
        attack.start();
    }

    public Monster(double attackDamage, double speed){
        this.attackDamage = attackDamage;
        setMovementSpeed(speed);
    }

}
