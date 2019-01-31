package com.company.Items.BlockPlacers;

import com.company.ImageBank;
import com.company.Tiles.Tile_Const_StoneWall;

public class Trowel extends TilePlacer {

    public Trowel(){
        super(Tile_Const_StoneWall.class, 5);
        setName("Trowel");
        setImage(ImageBank.getItemTiles1(),1,0);
    }
}
