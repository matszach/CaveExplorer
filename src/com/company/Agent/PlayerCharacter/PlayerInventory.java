package com.company.Agent.PlayerCharacter;

import com.company.Items.Drills.CopperDrill;
import com.company.Items.Item;
import com.company.Resources.Resource;

public class PlayerInventory {

    // Items
    private Item[][] itemsInInventory = new Item[10][6]; // 2 "slots" are left unused (5,8), (5,9)
    public Item[][] getItemsInInventory() {
        return itemsInInventory;
    }

    public void putItemInSlot(Item item, int rowX, int rowY){
        itemsInInventory[rowX][rowY] = item;
    }
    public void removeItemInSlot(int rowX, int rowY){
        itemsInInventory[rowX][rowY] = null; // todo might need to make changes in inv. window
    }

    // Resource
    private Resource[] resources = new Resource[10];
    public Resource getResource(Resource.ResourceType resourceType){
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
        putItemInSlot(new CopperDrill(), 0,0);
        putItemInSlot(new CopperDrill(), 1,0);
        putItemInSlot(new CopperDrill(), 0,3);
        putItemInSlot(new CopperDrill(), 0,5);

    }
}
