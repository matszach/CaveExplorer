package com.company.Tiles;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.CaveExplorer;
import com.company.ImageBank;
import com.company.Resources.Resource;
import javafx.geometry.Rectangle2D;

public class Tile_Const_StoneWall extends Tile {

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(2,0);
    }

    public Tile_Const_StoneWall(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(10);
    }
}
