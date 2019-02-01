package com.company.Crafting;

import com.company.Agent.PlayerCharacter.PlayerInventory;
import com.company.CaveExplorer;
import com.company.Items.Item;
import com.company.Resources.ResourceType;

import java.util.ArrayList;

abstract public class CraftingRecipe {

    protected static Class<? extends Item> craftedItemClass;

    protected static ArrayList<Item> requiredItems = new ArrayList<>(); // should not require more than one of each item type

    private static int[] requiredResources = new int[10];
    protected static void setRequiredResource(ResourceType resourceType, int amt){
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
    protected static int getRequiredResource(ResourceType resourceType){
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

    public static boolean ingredientsPresent(){

        // checks if items required are present
        for(Item i : requiredItems){
            if(!CaveExplorer.getPlayerCharacter().getInventory().containsItemOfType(i.getClass())){
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

    public static void execute(){
        if (CaveExplorer.getPlayerCharacter().getInventory().hasEmptyItemSlot()){




        }
    }
}
