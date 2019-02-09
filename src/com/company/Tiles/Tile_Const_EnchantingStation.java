package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;
import com.company.Items.PlaceableObjects.EnchantingStation;
import com.company.Items.PlaceableObjects.Workshop;

final public class Tile_Const_EnchantingStation extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainItem(new EnchantingStation());
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(8,0);
    }

    public Tile_Const_EnchantingStation(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(5);
    }
}