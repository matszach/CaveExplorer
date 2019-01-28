package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;
import com.company.Resources.Resource;

public class Tile_Ore_Platinum extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainResource(7,(int)(Math.random()*2+1));
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(7,1);
    }

    public Tile_Ore_Platinum(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(8);
    }
}