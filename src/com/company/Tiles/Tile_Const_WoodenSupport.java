package com.company.Tiles;

import com.company.ImageBank;

public class Tile_Const_WoodenSupport extends Tile {

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(3,0);
    }

    public Tile_Const_WoodenSupport(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setDurability(2);
        setReplaceable(false);
    }
}
