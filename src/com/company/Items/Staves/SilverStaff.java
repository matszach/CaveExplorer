package com.company.Items.Staves;

import com.company.ImageBank;
import com.company.Projectiles.DmgProjectile_Ice;

final public class SilverStaff extends Staff {

    public SilverStaff(){
        super(DmgProjectile_Ice.class,15);
        setName("Silver Staff");
        setImage(ImageBank.getItemTiles1(),6,0);
    }
}
