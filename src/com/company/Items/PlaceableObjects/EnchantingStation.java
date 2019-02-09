package com.company.Items.PlaceableObjects;

import com.company.ImageBank;
import com.company.Tiles.Tile_Const_EnchantingStation;

final public class EnchantingStation extends PlaceableObject {

    public EnchantingStation(){
        super(Tile_Const_EnchantingStation.class);
        setName("Enchanting Station");
        setImage(ImageBank.getItemTiles1(),2,4);
    }

}