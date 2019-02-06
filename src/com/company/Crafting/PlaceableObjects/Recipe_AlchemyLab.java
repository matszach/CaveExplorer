package com.company.Crafting.PlaceableObjects;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PlaceableObjects.AlchemyLab;
import com.company.Items.PlaceableObjects.WoodenSupport;
import com.company.Items.PotionsAndElixirs.SilverFlask;
import com.company.Resources.ResourceType;

final public class Recipe_AlchemyLab extends CraftingRecipe {
        public Recipe_AlchemyLab(){
            super(AlchemyLab.class);
            setRequiredResource(ResourceType.GOLD,10);
            setRequiredResource(ResourceType.COPPER, 10);
            setRequiredResource(ResourceType.STONE, 10);
            getRequiredItems().add(SilverFlask.class);
            getRequiredItems().add(WoodenSupport.class);
            getRequiredItems().add(WoodenSupport.class);
        }
}
