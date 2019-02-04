package com.company.Items.Spears;

import com.company.Agent.Monster.Monster;
import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.Items.IUsableOnButtonPressed;
import com.company.Items.Item;
import com.company.MonsterSpawnerAndHandler;
import javafx.animation.AnimationTimer;

abstract public class Spear  extends Item implements IUsableOnButtonPressed {


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

                playerCharacter.setLongViewSize();

                if(animationTime <= USE_PHASES[0]){
                    playerCharacter.buildSpearAttackAppearance(0);
                } else if(animationTime <= USE_PHASES[1]){
                    playerCharacter.buildSpearAttackAppearance(1);
                } else if(animationTime <= USE_PHASES[2]) {
                    playerCharacter.buildSpearAttackAppearance(2);

                    if(animationTime == USE_PHASES[2]){


                        // damage EVERY enemy within effective range
                        double x = playerCharacter.getTileX();
                        double y = playerCharacter.getTileY();


                        switch (playerCharacter.getDirFacing()){
                            case LEFT: x-=2*sweepRange; break;
                            case LEFT_UP: x-=2*sweepRange; y-=2*sweepRange; break;
                            case UP: y-=2*sweepRange; break;
                            case RIGHT_UP: x+=2*sweepRange; y-=2*sweepRange; break;
                            case RIGHT: x+=2*sweepRange; break;
                            case RIGHT_DOWN: x+=2*sweepRange; y+=2*sweepRange; break;
                            case DOWN: y+=2*sweepRange; break;
                            case LEFT_DOWN: x-=2*sweepRange; y+=2*sweepRange; break;
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
                            break; // spears only hit one target

                        }

                        // resets animation , permits another attack
                        playerCharacter.setDefaultViewSize();
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

    public Spear(double attackPower, double sweepRange){
        this.attackPower = attackPower;
        this.sweepRange = sweepRange;
    }

}