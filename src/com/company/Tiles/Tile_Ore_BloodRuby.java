package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;

final public class Tile_Ore_BloodRuby extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainResource(9,(int)(Math.random()*2+1));
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(9,1);
    }

    public Tile_Ore_BloodRuby(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(6);
    }
}