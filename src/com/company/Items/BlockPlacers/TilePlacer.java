package com.company.Items.BlockPlacers;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.Items.IUsableOnButtonHeld;
import com.company.Items.Item;
import com.company.Resources.ResourceType;
import com.company.Tiles.Tile;

abstract public class TilePlacer extends Item implements IUsableOnButtonHeld {

    private Class<? extends Tile> blockToPlace;
    private int price;


    @Override
    public void usage(PlayerCharacter playerCharacter, int animationTime) {
        if(playerCharacter.getInventory().getResource(ResourceType.STONE).isEnough(price)){
            try{
                if(playerCharacter.buildTile(blockToPlace.newInstance())){
                    playerCharacter.getInventory().getResource(ResourceType.STONE).lose(price);
                }
            } catch (Exception e){//TODO
            }
        }
    }

    @Override
    public int getUsageRotationLimit() {
        return 5;
    }

    public TilePlacer(Class blockToPlace, int price){
        this.blockToPlace = blockToPlace;
        this.price = price;

    }
}
