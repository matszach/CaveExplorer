package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;

final public class Tile_Ore_Cobalt extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainResource(8,(int)(Math.random()*2+1));
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(8,1);
    }

    public Tile_Ore_Cobalt(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(9);
    }
}