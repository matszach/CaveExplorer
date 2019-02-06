package com.company.Crafting;

import com.company.CaveExplorer;
import com.company.Items.Item;
import com.company.Resources.ResourceType;
import com.company.Scenes.MainGameScene;
import com.company.Tiles.Tile;

import java.util.ArrayList;

abstract public class CraftingRecipe {

    private Class<? extends Item> craftedItemClass;
    public Class<? extends Item> getCraftedItemClass() {
        return craftedItemClass;
    }

    // todo
    // checking for required items doesn't yet work when multiple item sof the same class are required
    // for now : should not require more than one of each item type
    private ArrayList<Class<? extends Item>> requiredItems = new ArrayList<>();  public ArrayList<Class<? extends Item>> getRequiredItems() {
        return requiredItems;
    }

    private int[] requiredResources = new int[10];
    public int[] getRequiredResources() {
        return requiredResources;
    }
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

            int amountOfItemsOfThisTypeRequired = 0;

            for(Object o : requiredItems){
                if(o.equals(itemClass)){
                    amountOfItemsOfThisTypeRequired++;
                }
            }

            if(!CaveExplorer.getPlayerCharacter().getInventory().containsItemsOfType(itemClass,amountOfItemsOfThisTypeRequired)){
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

    // overridable
    public boolean otherRequirementsMet(){
        return true;
    }

    // for recipes that require certain crafting stations nearby, etc
    public boolean tileOfTypeInRange(Class<? extends Tile> classTile, int range){

        int xMin = CaveExplorer.getPlayerCharacter().roundTileX() - range;
        int yMin = CaveExplorer.getPlayerCharacter().roundTileY() - range;
        int xMax = CaveExplorer.getPlayerCharacter().roundTileX() + range;
        int yMax = CaveExplorer.getPlayerCharacter().roundTileY() + range;

        for(int x = xMin; x <= xMax; x++){
            for(int y = yMin; y <= yMax; y++){
                if(MainGameScene.getBoard().getTiles()[x][y].getClass() == classTile){
                    return true;
                }
            }
        }

        return false;
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

        if (!ingredientsPresent() || !CaveExplorer.getPlayerCharacter().getInventory().hasEmptyItemSlot() || !otherRequirementsMet()){
            return;
        }

        payCost();
        createdAndAddItem();
    }

    public CraftingRecipe(Class<? extends Item> craftedItemClass){
        this.craftedItemClass = craftedItemClass;
    }
}
