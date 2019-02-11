package com.company.Projectiles;

import com.company.ImageBank;
import com.company.Tiles.Tile;

public class DmgProjectile_SporeCarrier_Spores extends DamagingProjectile {

    @Override
    void setProjectileAppearance() {
        setImage(ImageBank.getProjectileTiles1());
        setFitWidth(32);
        setFitHeight(32);
        viewport1 = buildViewportByGrid(3,0);
        viewport2 = buildViewportByGrid(3,1);
        viewport3 = buildViewportByGrid(3,2);
    }

    @Override
    void collisionWithTileEffect(Tile tile) {
        finalizeTravel();
    }

    public DmgProjectile_SporeCarrier_Spores(double averageDamage){
        super(0.08, 4, averageDamage);
        ignoresMonsters = true;
    }

}
