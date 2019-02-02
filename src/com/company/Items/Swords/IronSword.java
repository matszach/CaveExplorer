package com.company.Items.Swords;

import com.company.ImageBank;

public class IronSword extends Sword{

    public IronSword(){
        super(12);
        setName("Iron Sword");
        setImage(ImageBank.getItemTiles1(),3,1);
    }
}
