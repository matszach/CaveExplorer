package com.company.Items.PlaceableObjects;

import com.company.ImageBank;
import com.company.Tiles.Tile_Const_Fireplace;

final public class Fireplace extends PlaceableObject {

    public Fireplace(){
        super(Tile_Const_Fireplace.class);
        setName("Fireplace");
        setImage(ImageBank.getItemTiles1(),2,3);
    }

}