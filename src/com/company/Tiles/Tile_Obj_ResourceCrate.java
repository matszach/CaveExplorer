package com.company.Tiles;


import com.company.CaveExplorer;
import com.company.ImageBank;

public class Tile_Obj_ResourceCrate extends Tile implements IResourceDropping {

    @Override
    public void dropResource() {
        // drops any random resource except stone (so 1 through 9) in large amount
        CaveExplorer.getPlayerCharacter().gainResource((int)(Math.random()*9+1),(int)(Math.random()*20+20));
    }

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(0,3);
    }

    public Tile_Obj_ResourceCrate(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(1);
    }
}