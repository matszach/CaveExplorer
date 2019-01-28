package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;
import com.company.Resources.Resource;

public class Tile_Ore_Coal extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainResource(1,(int)(Math.random()*3+2));
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(1,1);
    }

    public Tile_Ore_Coal(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(4);
    }
}