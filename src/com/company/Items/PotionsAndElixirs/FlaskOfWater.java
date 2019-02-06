package com.company.Items.PotionsAndElixirs;

import com.company.CaveExplorer;
import com.company.ImageBank;

final public class FlaskOfWater extends Potion {

    @Override
    void takeEffect() {
        CaveExplorer.getPlayerCharacter().healDamage(10+Math.random()*11); // 10-20
    }

    public FlaskOfWater(){
        setName("Flask of Water");
        setImage(ImageBank.getItemTiles1(),7,1);

    }

}
