package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;
import com.company.Items.PlaceableObjects.AlchemyLab;

final public class Tile_Const_AlchemyLab extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainItem(new AlchemyLab());
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(6,0);
    }

    public Tile_Const_AlchemyLab(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(5);
    }
}