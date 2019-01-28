package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;
import com.company.Resources.Resource;

public class Tile_Ore_Silver extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainResource(5,(int)(Math.random()*3+1));
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(5,1);
    }

    public Tile_Ore_Silver(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(6);
    }
}