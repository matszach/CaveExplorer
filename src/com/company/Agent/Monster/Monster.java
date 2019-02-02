package com.company.Agent.Monster;

import com.company.Agent.Agent;
import com.company.Agent.Monster.MonsterAI.MonsterAI;
import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.CaveExplorer;
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


    private boolean playerInMeleeRange(){
        return Math.abs(getTileX() - CaveExplorer.getPlayerCharacter().getTileX()) <= 1 && Math.abs(getTileY() - CaveExplorer.getPlayerCharacter().getTileY()) <= 1;
    }

    private boolean attackInProgress = false;

    public void attemptAttack(){

        if(!playerInMeleeRange() || attackInProgress){
            return;
        }

        attackInProgress = true;

        AnimationTimer attack = new AnimationTimer() {

            int USE_PHASES[] = new int[]{4,26,40};
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

                        // TODO
                        // damage player if still close enough (~1.25 tiles or so)
                    }
                }
                animationTime++;
            }
        };
        attack.start();
    }
}
