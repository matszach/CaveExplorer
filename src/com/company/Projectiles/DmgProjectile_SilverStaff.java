package com.company.Projectiles;

import com.company.Agent.Agent;
import com.company.ImageBank;
import com.company.Tiles.Tile;

final public class DmgProjectile_SilverStaff extends DamagingProjectile {

    @Override
    void setProjectileAppearance() {
        setImage(ImageBank.getProjectileTiles1());
        setFitWidth(32);
        setFitHeight(32);
        viewport1 = buildViewportByGrid(0,0);
        viewport2 = buildViewportByGrid(0,1);
        viewport3 = buildViewportByGrid(0,2);
    }

    @Override
    void collisionWithTileEffect(Tile tile) {
        tile.takeDamage(0.3); // symbolic damage to tiles
        finalizeTravel();
    }

    public DmgProjectile_SilverStaff(Agent.MOVE_DIR move_dir){
        super(move_dir, 0.12, 6, 15);
        ignoresPlayer = true;
    }

}
