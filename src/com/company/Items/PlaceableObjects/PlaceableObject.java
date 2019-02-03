package com.company.Items.PlaceableObjects;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.Items.IUsableOnButtonHeld;
import com.company.Items.Item;
import com.company.Tiles.Tile;

abstract public class PlaceableObject extends Item implements IUsableOnButtonHeld {

    private Class<? extends Tile> blockToPlace;

    @Override
    public void usage(PlayerCharacter playerCharacter, int animationTime) {
            try{
                if(playerCharacter.buildTile(blockToPlace.newInstance())){
                    playerCharacter.getInventory().removeSpecificItem(this);
                }
            } catch (Exception e){//TODO
            }
    }

    @Override
    public int getUsageRotationLimit() {
        return 20;
    }

    public PlaceableObject(Class blockToPlace){
        this.blockToPlace = blockToPlace;
    }
}

