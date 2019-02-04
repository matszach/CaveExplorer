package com.company.Crafting;

import com.company.CaveExplorer;
import com.company.Items.Item;
import com.company.Resources.ResourceType;

import java.util.ArrayList;

abstract public class CraftingRecipe {

    protected Class<? extends Item> craftedItemClass;

    protected ArrayList<Class<? extends Item>> requiredItems = new ArrayList<>(); // should not require more than one of each item type

    private int[] requiredResources = new int[10];
    protected void setRequiredResource(ResourceType resourceType, int amt){
        switch (resourceType){
            case STONE: requiredResources[0]=amt; break;
            case COAL: requiredResources[1]=amt; break;
            case COPPER: requiredResources[2]=amt; break;
            case IRON: requiredResources[3]=amt; break;
            case SULFUR: requiredResources[4]=amt; break;
            case SILVER: requiredResources[5]=amt; break;
            case GOLD: requiredResources[6]=amt; break;
            case PLATINUM: requiredResources[7]=amt; break;
            case COBALT: requiredResources[8]=amt; break;
            case BLOOD_RUBY: requiredResources[9]=amt; break;
        }
    }
    protected int getRequiredResource(ResourceType resourceType){
        switch (resourceType){
            case STONE: return requiredResources[0];
            case COAL: return requiredResources[1];
            case COPPER: return requiredResources[2];
            case IRON: return requiredResources[3];
            case SULFUR: return requiredResources[4];
            case SILVER: return requiredResources[5];
            case GOLD: return requiredResources[6];
            case PLATINUM: return requiredResources[7];
            case COBALT: return requiredResources[8];
            case BLOOD_RUBY: return requiredResources[9];
            default: return 0;
        }
    }

    public boolean ingredientsPresent(){

        // checks if items required are present
        for(Class<? extends Item> itemClass : requiredItems){
            if(!CaveExplorer.getPlayerCharacter().getInventory().containsItemOfType(itemClass)){
                return false;
            }
        }

        // set if required amount of resources is present
        for(int i = 0; i < requiredResources.length; i++){
            if(CaveExplorer.getPlayerCharacter().getInventory().getResource(i).getAmount() < requiredResources[i]){
                return false;
            }
        }
        return true;
    }

    private void payCost(){

        for(int i = 0; i < requiredResources.length; i++){
           CaveExplorer.getPlayerCharacter().getInventory().getResource(i).lose(requiredResources[i]);
        }

        for(Class<? extends Item> itemClass : requiredItems){
            CaveExplorer.getPlayerCharacter().getInventory().removeOneItemOfType(itemClass);
        }

    }
    private void createdAndAddItem(){

        try {
            Item itemToBeCreated;
            itemToBeCreated = craftedItemClass.newInstance();
            CaveExplorer.getPlayerCharacter().gainItem(itemToBeCreated);
        } catch (Exception e){

        }

    }

    public void execute(){

        // TODO  ??
        // stops the method if either the player doesn't have necessary ingredients
        // or has no empty inventory slots - both of those should already be impossible if this methods
        // was allowed to be executed

        if (!ingredientsPresent() || !CaveExplorer.getPlayerCharacter().getInventory().hasEmptyItemSlot()){
            return;
        }

        payCost();
        createdAndAddItem();
    }

    public CraftingRecipe(Class<? extends Item> craftedItemClass){
        this.craftedItemClass = craftedItemClass;
    }
}
