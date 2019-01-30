package com.company.Items.Drills;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.CaveExplorer;
import com.company.Items.IUsable;
import com.company.Items.Item;

abstract public class Drill extends Item implements IUsable {

    // todo will be used to decide the damage dealt to drilled tiles
    // drilling power
    double drillingPower;
    public void setDrillingPower(double drillingPower) {
        this.drillingPower = drillingPower;
    }
    public double getDrillingPower() {
        return drillingPower;
    }

    private static final int USE_PHASES[] = new int[]{2,4,6,8};

    @Override
    public void usage(PlayerCharacter playerCharacter, int animationTime) {
        if(animationTime <= USE_PHASES[0]){
            CaveExplorer.getPlayerCharacter().buildDrillingAppearance(0);
        } else if(animationTime <= USE_PHASES[1]){
            CaveExplorer.getPlayerCharacter().buildDrillingAppearance(1);
        } else if(animationTime <= USE_PHASES[2]) {
            CaveExplorer.getPlayerCharacter().buildDrillingAppearance(2);
        } else if(animationTime <= USE_PHASES[3]){
            CaveExplorer.getPlayerCharacter().buildDrillingAppearance(1);
            if(animationTime == USE_PHASES[3]){
                CaveExplorer.getPlayerCharacter().damageTile(drillingPower);
            }
        }
    }

    @Override
    public int getUsageRotationLimit() {
        return USE_PHASES[3];
    }

    public Drill(double drillingPower){
        this.drillingPower = drillingPower;
    }

}
