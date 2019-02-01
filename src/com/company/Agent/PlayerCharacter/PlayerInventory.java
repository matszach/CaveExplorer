package com.company.Agent.PlayerCharacter;

import com.company.Items.BlockPlacers.Trowel;
import com.company.Items.Drills.BloodRubyDrill;
import com.company.Items.Drills.CobaltDrill;
import com.company.Items.Drills.CopperDrill;
import com.company.Items.Drills.IronDrill;
import com.company.Items.Item;
import com.company.Resources.Resource;
import com.company.Resources.ResourceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerInventory {

    // Items
    private Item[][] itemsInInventory = new Item[10][6];
    public Item[][] getItemsInInventory() {
        return itemsInInventory;
    }

    public void putItemInSlot(Item item, int row, int col){
        itemsInInventory[row][col] = item;
    }
    public void removeItemInSlot(int row, int col){
        itemsInInventory[row][col] = null; // todo might need to make changes in inv. window
    }

    // checks for an empty item slot
    public boolean hasEmptyItemSlot(){
        for (int col = 0; col < itemsInInventory[0].length; col++){
            for (int row = 0; row < itemsInInventory.length; row++){
                if(itemsInInventory[row][col] == null){
                    return true;
                }
            }
        }
        return false;
    }


    // adds item to a first possible slot, ignores action bar slots
    private boolean addOneItemToInventory(Item item){
        for (int col = 0; col < itemsInInventory[0].length; col++){
            for (int row = 0; row < itemsInInventory.length; row++){
                if(itemsInInventory[row][col] == null){
                    itemsInInventory[row][col] = item;
                    return true;
                }
            }
        }
        return false;
    }
    public void addItemsToInventory(Item... item){
        for(Item i : item){
            addOneItemToInventory(i);
        }
    }

    // checks if inventory contains an item of a given type
    public boolean containsItemOfType(Class<? extends Item> itemClass){
        for (int col = 0; col < itemsInInventory[0].length; col++){
            for (int row = 0; row < itemsInInventory.length-1; row++){
                if(itemsInInventory[row][col] != null && itemsInInventory[row][col].getClass() == itemClass){
                    return true;
                }
            }
        }
       return false;
    }

    // removes one instance of an item of a specific type
    public boolean removeOneItemOfType(Class<? extends Item> itemClass){
        for (int col = 0; col < itemsInInventory[0].length; col++){
            for (int row = 0; row < itemsInInventory.length-1; row++){
                if(itemsInInventory[row][col] != null && itemsInInventory[row][col].getClass() == itemClass){
                    removeItemInSlot(row, col);
                }
            }
        }
        return false;
    }

    // Resource
    private Resource[] resources = new Resource[10];
    public Resource getResource(ResourceType resourceType){
        switch (resourceType){
            case STONE: return resources[0];
            case COAL: return resources[1];
            case COPPER: return resources[2];
            case IRON: return resources[3];
            case SULFUR: return resources[4];
            case SILVER: return resources[5];
            case GOLD: return resources[6];
            case PLATINUM: return resources[7];
            case COBALT: return resources[8];
            case BLOOD_RUBY: return resources[9];
            default: return null;
        }
    }
    public Resource getResource(int resourceType){
        return resources[resourceType];
    }

    public PlayerInventory(){

        // FOR EACH DOESN'T WORK FOR NULL_FILLED ARRAY
        for(int i = 0; i < resources.length; i++){
            resources[i] = new Resource();
        }


        // TODO TEST
        addItemsToInventory(new CopperDrill(), new IronDrill(), new CobaltDrill(), new BloodRubyDrill(), new Trowel());

    }
}
