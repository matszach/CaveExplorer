package com.company.Tiles;

import com.company.ImageBank;

final public class Tile_Fluid_Water extends Tile{

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(0,2);
    }

    public Tile_Fluid_Water(){
        super();
        setMovementBlocking(true);
        setBreakable(false);
        setReplaceable(true);
    }
}