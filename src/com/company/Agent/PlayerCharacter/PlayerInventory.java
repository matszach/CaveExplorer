package com.company.Agent.PlayerCharacter;

import com.company.Items.Daggers.CopperDagger;
import com.company.Items.Drills.CopperDrill;
import com.company.Items.Item;
import com.company.Items.PotionsAndElixirs.PotionOfHealing;
import com.company.Items.Staves.GoldStaff;
import com.company.Items.Staves.PlatinumStaff;
import com.company.Items.Staves.SilverStaff;
import com.company.Resources.Resource;
import com.company.Resources.ResourceType;
import com.company.Scenes.MainGameScene;


public class PlayerInventory {

    // Items
    private Item[][] itemsInInventory = new Item[10][6];
    public Item[][] getItemsInInventory() {
        return itemsInInventory;
    }

    // in-game-method
    public void putItemInSlot(Item item, int col, int row){
        itemsInInventory[col][row] = item;
        MainGameScene.getInventoryWindow().updateItemPane(col,row);
    }
    public void removeItemInSlot(int col,int row){
        itemsInInventory[col][row] = null;
        MainGameScene.getInventoryWindow().updateItemPane(col,row);
    }

    // load game-state method
    // in-game-method
    public void loadItemIntoSlot(Item item, int col, int row){
        itemsInInventory[col][row] = item;
    }


    // checks for an empty item slot
    public boolean hasEmptyItemSlot(){
        for (int row = 0; row < itemsInInventory[0].length; row++){
            for (int col = 0; col < itemsInInventory.length; col++){
                if(itemsInInventory[col][row] == null){
                    return true;
                }
            }
        }
        return false;
    }


    // adds item to a first possible slot, ignores action bar slots
    private boolean addOneItemToInventory(Item item){
        for (int row = 0; row < itemsInInventory[0].length; row++){
            for (int col = 0; col < itemsInInventory.length; col++){
                if(itemsInInventory[col][row] == null){
                    putItemInSlot(item, col, row);
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
        for (int row = 0; row < itemsInInventory[0].length; row++){
            for (int col = 0; col < itemsInInventory.length-1; col++){
                if(itemsInInventory[col][row] != null && itemsInInventory[col][row].getClass() == itemClass){
                    return true;
                }
            }
        }
       return false;
    }
    public boolean containsItemsOfType(Class<? extends Item> itemClass, int quantity){

        int itemsOfTypeFound = 0;

        for (int row = 0; row < itemsInInventory[0].length; row++){
            for (int col = 0; col < itemsInInventory.length-1; col++){
                if(itemsInInventory[col][row] != null && itemsInInventory[col][row].getClass() == itemClass){
                    itemsOfTypeFound++;
                }
            }
        }
        return itemsOfTypeFound >= quantity;
    }

    // removes one instance of an item of a specific type
    public boolean removeOneItemOfType(Class<? extends Item> itemClass){
        for (int row = 0; row < itemsInInventory[0].length; row++){
            for (int col = 0; col < itemsInInventory.length-1; col++){
                if(itemsInInventory[col][row] != null && itemsInInventory[col][row].getClass() == itemClass){
                    removeItemInSlot(col,row);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean removeSpecificItem(Item item){
        for (int row = 0; row < itemsInInventory[0].length; row++){
            for (int col = 0; col < itemsInInventory.length; col++){
                if(itemsInInventory[col][row] == item){
                    removeItemInSlot(col, row);
                    return true;
                }
            }
        }
        return false;
    }


    // adds starting items ( those are written over when a game is loaded instead of
    // a new one getting started, this might be moved later
    private void addStartingItems(){
        itemsInInventory[0][5] = new CopperDrill();
        itemsInInventory[1][5] = new CopperDagger();
        itemsInInventory[0][0] = new PotionOfHealing();
        itemsInInventory[1][0] = new SilverStaff();
        itemsInInventory[2][0] = new GoldStaff();
        itemsInInventory[3][0] = new PlatinumStaff();
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

        for(int i = 0; i < resources.length; i++){
            resources[i] = new Resource();
        }

        addStartingItems();

    }
}
