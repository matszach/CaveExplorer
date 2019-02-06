package com.company.Items.PotionsAndElixirs;

import com.company.CaveExplorer;
import com.company.ImageBank;

final public class PotionOfHealing extends Potion{

    @Override
    void takeEffect() {
        CaveExplorer.getPlayerCharacter().healDamage(40+Math.random()*21); // 40-60
    }

    public PotionOfHealing(){
        setName("Potion of Healing");
        setImage(ImageBank.getItemTiles1(),7,2);

    }
}
