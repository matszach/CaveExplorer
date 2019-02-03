package com.company.Items.Swords;

import com.company.ImageBank;

final public class CopperSword extends Sword{

    public CopperSword(){
        super(16, 0.75);
        setName("Copper Sword");
        setImage(ImageBank.getItemTiles1(),3,0);
    }
}
