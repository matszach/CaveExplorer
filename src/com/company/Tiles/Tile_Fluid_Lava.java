package com.company.Tiles;

import com.company.ImageBank;

final public class Tile_Fluid_Lava extends Tile{

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(1,2);
    }

    public Tile_Fluid_Lava(){
        super();
        setMovementBlocking(true);
        setBreakable(false);
        setReplaceable(true);
    }
}