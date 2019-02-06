package com.company.Tiles;

import com.company.ImageBank;
import javafx.scene.effect.ColorAdjust;

final public class Tile_Floor extends Tile{

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(0,0);
    }

    public Tile_Floor(){
        super();
        setMovementBlocking(false);
        setBreakable(false);
        setReplaceable(true);
    }
}