package com.company.Items.Staves;

import com.company.ImageBank;
import com.company.Projectiles.DmgProjectile_Fire;

final public class GoldStaff extends Staff {
    public GoldStaff(){
        super(DmgProjectile_Fire.class,18);
        setName("Gold Staff");
        setImage(ImageBank.getItemTiles1(),6,1);
    }
}
