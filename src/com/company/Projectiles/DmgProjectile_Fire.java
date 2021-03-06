package com.company.Projectiles;

import com.company.Agent.Agent;
import com.company.ImageBank;
import com.company.Tiles.Tile;

final public class DmgProjectile_Fire extends DamagingProjectile {

    @Override
    void setProjectileAppearance() {
        setImage(ImageBank.getProjectileTiles1());
        setFitWidth(32);
        setFitHeight(32);
        viewport1 = buildViewportByGrid(1,0);
        viewport2 = buildViewportByGrid(1,1);
        viewport3 = buildViewportByGrid(1,2);
    }

    @Override
    void collisionWithTileEffect(Tile tile) {
        tile.takeDamage(0.8); // noticeable damage to tiles
        finalizeTravel();
    }


    public DmgProjectile_Fire(double averageDamage){
        super(0.15, 7, averageDamage);
        ignoresPlayer = true;
    }

}