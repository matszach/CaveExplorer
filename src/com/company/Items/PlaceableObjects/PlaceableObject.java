package com.company.Items.PlaceableObjects;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.Items.IUsableOnButtonPressed;
import com.company.Items.Item;
import com.company.Tiles.Tile;

abstract public class PlaceableObject extends Item implements IUsableOnButtonPressed {

    private Class<? extends Tile> blockToPlace;

    @Override
    public void usage(PlayerCharacter playerCharacter) {
            try{
                if(playerCharacter.buildTile(blockToPlace.newInstance())){
                    playerCharacter.getInventory().removeSpecificItem(this);
                }
            } catch (Exception e){//TODO
            }
    }

    @Override
    public boolean usageInProgress() {
        return false;
    }

    public PlaceableObject(Class blockToPlace){
        this.blockToPlace = blockToPlace;
    }
}

