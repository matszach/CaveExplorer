package com.company.Items.Staves;

import com.company.ImageBank;
import com.company.Projectiles.DmgProjectile_Force;

final public class PlatinumStaff extends Staff {
    public PlatinumStaff() {
        super(DmgProjectile_Force.class, 21);
        setName("Platinum Staff");
        setImage(ImageBank.getItemTiles1(), 6, 2);
    }
}