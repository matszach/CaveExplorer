package com.company.Agent.PlayerCharacter;

import com.company.Items.BlockPlacers.Trowel;
import com.company.Items.Daggers.BloodRubyDagger;
import com.company.Items.Daggers.CobaltDagger;
import com.company.Items.Daggers.CopperDagger;
import com.company.Items.Daggers.IronDagger;
import com.company.Items.Drills.BloodRubyDrill;
import com.company.Items.Drills.CobaltDrill;
import com.company.Items.Drills.CopperDrill;
import com.company.Items.Drills.IronDrill;
import com.company.Items.Item;
import com.company.Items.PlaceableObjects.WoodenSupport;
import com.company.Items.PotionsAndElixirs.PotionOfHealing;
import com.company.Items.Spears.BloodRubySpear;
import com.company.Items.Spears.CobaltSpear;
import com.company.Items.Spears.CopperSpear;
import com.company.Items.Spears.IronSpear;
import com.company.Items.Swords.BloodRubySword;
import com.company.Items.Swords.CobaltSword;
import com.company.Items.Swords.CopperSword;
import com.company.Items.Swords.IronSword;
import com.company.Resources.Resource;
import com.company.Resources.ResourceType;
import com.company.Scenes.MainGameScene;


public class PlayerInventory {

    // Items
    private Item[][] itemsInInventory = new Item[10][6];
    public Item[][] getItemsInInventory() {
        return itemsInInventory;
    }

    public void putItemInSlot(Item item, int col, int row){
        itemsInInventory[col][row] = item;
        MainGameScene.getInventoryWindow().updateItemPane(col,row);
    }
    public void removeItemInSlot(int col,int row){
        itemsInInventory[col][row] = null;
        MainGameScene.getInventoryWindow().updateItemPane(col,row);
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
            for (int col = 0; col < itemsInInventory.length-1; col++){
                if(itemsInInventory[col][row] == item){
                    removeItemInSlot(col, row);
                    return true;
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
        /*
        these would cause an exception (inventory window forced to update before it is created)
        addItemsToInventory(new CopperDrill(), new IronDrill(), new CobaltDrill(), new BloodRubyDrill(), new Trowel());
        addItemsToInventory(new WoodenSupport(),new WoodenSupport(),new WoodenSupport(),new WoodenSupport(),new WoodenSupport());
        */

        itemsInInventory[0][0] = new CopperDrill();
        itemsInInventory[1][0] = new IronDrill();
        itemsInInventory[2][0] = new CobaltDrill();
        itemsInInventory[3][0] = new BloodRubyDrill();
        itemsInInventory[4][0] = new Trowel();
        itemsInInventory[0][1] = new WoodenSupport();
        itemsInInventory[1][1] = new WoodenSupport();
        itemsInInventory[2][1] = new WoodenSupport();
        itemsInInventory[3][1] = new WoodenSupport();
        itemsInInventory[4][1] = new WoodenSupport();
        itemsInInventory[0][2] = new CopperSword();
        itemsInInventory[1][2] = new IronSword();
        itemsInInventory[2][2] = new CobaltSword();
        itemsInInventory[3][2] = new BloodRubySword();
        itemsInInventory[0][3] = new CopperDagger();
        itemsInInventory[1][3] = new IronDagger();
        itemsInInventory[2][3] = new CobaltDagger();
        itemsInInventory[3][3] = new BloodRubyDagger();
        itemsInInventory[0][4] = new CopperSpear();
        itemsInInventory[1][4] = new IronSpear();
        itemsInInventory[2][4] = new CobaltSpear();
        itemsInInventory[3][4] = new BloodRubySpear();
        itemsInInventory[0][5] = new PotionOfHealing();
        itemsInInventory[1][5] = new PotionOfHealing();
        itemsInInventory[2][5] = new PotionOfHealing();
    }
}
