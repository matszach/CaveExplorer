package com.company.Tiles;

import com.company.ImageBank;

final public class Tile_Gravel extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        // todo
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(4, 0);
    }

    public Tile_Gravel() {
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(1.5);
    }
}
