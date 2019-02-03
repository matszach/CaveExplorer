package com.company.Items.Swords;

import com.company.Agent.Monster.Monster;
import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.Items.IUsableOnButtonPressed;
import com.company.Items.Item;
import com.company.MonsterSpawnerAndHandler;
import javafx.animation.AnimationTimer;

abstract public class Sword extends Item implements IUsableOnButtonPressed {


    // attack power
    private double attackPower;

    // sweep range
    private double sweepRange;

    // prevents staring another attack when the first one is in motion
    private boolean attackInProgress = false;


    @Override
    public void usage(PlayerCharacter playerCharacter) {

        attackInProgress = true;

        AnimationTimer attack = new AnimationTimer() {

            int USE_PHASES[] = new int[]{10,30,50};
            int animationTime = 0;


            @Override
            public void handle(long now) {

                if(animationTime <= USE_PHASES[0]){
                    playerCharacter.buildMeleeAttackAppearance(0);
                } else if(animationTime <= USE_PHASES[1]){
                    playerCharacter.buildMeleeAttackAppearance(1);
                } else if(animationTime <= USE_PHASES[2]) {
                    playerCharacter.buildMeleeAttackAppearance(2);

                    if(animationTime == USE_PHASES[2]){


                        // damage EVERY enemy within effective range
                        double x = playerCharacter.getTileX();
                        double y = playerCharacter.getTileY();


                        switch (playerCharacter.getDirFacing()){
                            case LEFT: x-=sweepRange; break;
                            case LEFT_UP: x-=sweepRange; y-=sweepRange; break;
                            case UP: y-=sweepRange; break;
                            case RIGHT_UP: x+=sweepRange; y-=sweepRange; break;
                            case RIGHT: x+=sweepRange; break;
                            case RIGHT_DOWN: x+=sweepRange; y+=sweepRange; break;
                            case DOWN: y+=sweepRange; break;
                            case LEFT_DOWN: x-=sweepRange; y+=sweepRange; break;
                            default: break;
                        }


                        // deals damage to ALL enemies withing area
                        for(Monster monster : MonsterSpawnerAndHandler.getActiveMonsters()){
                            if(Math.abs(monster.getTileX() - x) > sweepRange){
                                continue;
                            }
                            if(Math.abs(monster.getTileY() - y) > sweepRange){
                                continue;
                            }
                            double damageToBeDealt = attackPower/2 + Math.random()*attackPower;
                            monster.takeDamage(damageToBeDealt);

                        }

                        // resets animation , permits another attack
                        playerCharacter.buildDefaultAppearance();
                        animationTime = 0;
                        attackInProgress = false;
                        stop();



                    }
                }
                animationTime++;
            }
        };
        attack.start();
    }

    @Override
    public boolean usageInProgress() {
        return attackInProgress;
    }

    public Sword(double attackPower, double sweepRange){
        this.attackPower = attackPower;
        this.sweepRange = sweepRange;
    }

}
