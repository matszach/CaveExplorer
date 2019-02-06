package com.company.Items.PlaceableObjects;

import com.company.ImageBank;
import com.company.Tiles.Tile_Const_Workshop;

final public class Workshop extends PlaceableObject{

    public Workshop(){
        super(Tile_Const_Workshop.class);
        setName("Workshop");
        setImage(ImageBank.getItemTiles1(),2,1);
    }

}
