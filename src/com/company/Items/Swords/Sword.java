package com.company.Items.Swords;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.CaveExplorer;
import com.company.Items.IUsable;
import com.company.Items.Item;

abstract public class Sword extends Item implements IUsable {

    // todo will be used to decide the attackPower dealt to drilled tiles
    // drilling power
    private double attackPower;
    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }
    public double getAttackPower() {
        return attackPower;
    }

    private static final int USE_PHASES[] = new int[]{4,20,26};

    @Override
    public void usage(PlayerCharacter playerCharacter, int animationTime) {
        if(animationTime <= USE_PHASES[0]){
            CaveExplorer.getPlayerCharacter().buildMeleeAttackAppearance(0);
        } else if(animationTime <= USE_PHASES[1]){
            CaveExplorer.getPlayerCharacter().buildMeleeAttackAppearance(1);
        } else if(animationTime <= USE_PHASES[2]) {
            CaveExplorer.getPlayerCharacter().buildMeleeAttackAppearance(2);
            if(animationTime == USE_PHASES[2]){
                //CaveExplorer.getPlayerCharacter().damageTile(attackPower);
            }
        }
    }

    @Override
    public int getUsageRotationLimit() {
        return USE_PHASES[2];
    }

    public Sword(double attackPower){
        this.attackPower = attackPower;
    }

}
