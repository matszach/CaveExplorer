package com.company.Items.Swords;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.CaveExplorer;
import com.company.Items.IUsableOnButtonPressed;
import com.company.Items.Item;
import javafx.animation.AnimationTimer;

abstract public class Sword extends Item implements IUsableOnButtonPressed {

    // todo will be used to decide the attackPower dealt to drilled tiles
    // drilling power
    private double attackPower;
    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }
    public double getAttackPower() {
        return attackPower;
    }

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

                        // resets animation , permits another attack
                        playerCharacter.buildDefaultAppearance();
                        animationTime = 0;
                        attackInProgress = false;
                        stop();

                        // TODO
                        // damage any (single?) enemy if still close enough (~1.25 tiles or so)
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

    public Sword(double attackPower){
        this.attackPower = attackPower;
    }

}
