package com.company.Tiles;

import com.company.Board.BoardBuilder.GeneratedStructures.OreVein;
import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.ImageBank;
import com.company.Resources.Resource;
import javafx.geometry.Rectangle2D;

public class Tile_Ore_Iron extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainResource(3,(int)(Math.random()*3+1));
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(3,1);
    }

    public Tile_Ore_Iron(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(5);
    }
}