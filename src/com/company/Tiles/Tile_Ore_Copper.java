package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;

final public class Tile_Ore_Copper extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainResource(2,(int)(Math.random()*3+2));
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(2,1);
    }

    public Tile_Ore_Copper(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(4);
    }
}