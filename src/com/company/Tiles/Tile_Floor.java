package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.ImageBank;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Tile_Floor extends Tile{

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