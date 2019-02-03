package com.company.Items.Swords;

import com.company.ImageBank;

final public class IronSword extends Sword{

    public IronSword(){
        super(19,0.8);
        setName("Iron Sword");
        setImage(ImageBank.getItemTiles1(),3,1);
    }
}
