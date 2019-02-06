package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;
import com.company.Items.PlaceableObjects.Workshop;

final public class Tile_Const_Workshop extends Tile implements IResourceDropping{

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainItem(new Workshop());
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(5,0);
    }

    public Tile_Const_Workshop(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(5);
    }
}