package com.company.Items.PlaceableObjects;

import com.company.ImageBank;
import com.company.Tiles.Tile_Const_WoodenSupport;

final public class WoodenSupport extends PlaceableObject {

    public WoodenSupport(){
        super(Tile_Const_WoodenSupport.class);
        setName("Wooden Support");
        setImage(ImageBank.getItemTiles1(),2,0);
    }
}
