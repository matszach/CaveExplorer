package com.company.Items.Drills;

import com.company.Items.Item;

abstract public class Drill extends Item {

    // todo will be used to decide the damage dealt to drilled tiles
    // drilling power
    double drillingPower;
    public void setDrillingPower(double drillingPower) {
        this.drillingPower = drillingPower;
    }
    public double getDrillingPower() {
        return drillingPower;
    }


    public Drill(double drillingPower){
        this.drillingPower = drillingPower;
    }

}
