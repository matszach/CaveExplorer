package com.company.Tiles;

import com.company.ImageBank;


public class Tile_Bedrock extends Tile {

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(1,0);
    }

    public Tile_Bedrock(){
        super();
        setMovementBlocking(true);
        setBreakable(false);
        setReplaceable(false);
    }
}
