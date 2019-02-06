package com.company.Tiles;

import com.company.ImageBank;

final public class Tile_Const_AlchemyLab extends Tile {

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(6,0);
    }

    public Tile_Const_AlchemyLab(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(5);
    }
}