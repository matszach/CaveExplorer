package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;

final public class Tile_Ore_Gold extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainResource(6,(int)(Math.random()*3+1));
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(6,1);
    }

    public Tile_Ore_Gold(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(6);
    }
}