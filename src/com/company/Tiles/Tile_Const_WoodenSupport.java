package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;
import com.company.Items.PlaceableObjects.WoodenSupport;

public class Tile_Const_WoodenSupport extends Tile implements IResourceDropping {

    private final double RECLAIM_CHANCE = 0.3;

    @Override
    public void dropResource() {
        if(Math.random() < RECLAIM_CHANCE){
            CaveExplorer.getPlayerCharacter().gainItem(new WoodenSupport());
        }
    }

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
