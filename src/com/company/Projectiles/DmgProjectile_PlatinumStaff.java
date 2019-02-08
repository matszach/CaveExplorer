package com.company.Projectiles;

import com.company.Agent.Agent;
import com.company.ImageBank;
import com.company.Tiles.Tile;

final public class DmgProjectile_PlatinumStaff extends DamagingProjectile {

    @Override
    void setProjectileAppearance() {
        setImage(ImageBank.getProjectileTiles1());
        setFitWidth(32);
        setFitHeight(32);
        viewport1 = buildViewportByGrid(2,0);
        viewport2 = buildViewportByGrid(2,1);
        viewport3 = buildViewportByGrid(2,2);
    }

    @Override
    void collisionWithTileEffect(Tile tile) {
        tile.takeDamage(0.05); // constant damage as the projectile passes through tiles
    }

    public DmgProjectile_PlatinumStaff(Agent.MOVE_DIR move_dir){
        super(move_dir, 0.10, 8, 25);
        ignoresPlayer = true;
    }

}