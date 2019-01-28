package com.company.Tiles;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.CaveExplorer;
import com.company.ImageBank;
import com.company.Resources.Resource;
import javafx.geometry.Rectangle2D;

public class Tile_Stone extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        CaveExplorer.getPlayerCharacter().gainResource(0,(int)(Math.random()*2+1));
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(0,1);
    }

    public Tile_Stone(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(3);
    }
}
