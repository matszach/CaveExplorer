package com.company.Items.PlaceableObjects;

import com.company.ImageBank;
import com.company.Tiles.Tile_Const_AlchemyLab;

final public class AlchemyLab extends PlaceableObject {

    public AlchemyLab(){
        super(Tile_Const_AlchemyLab.class);
        setName("Alchemy Lab");
        setImage(ImageBank.getItemTiles1(),2,2);
    }

}