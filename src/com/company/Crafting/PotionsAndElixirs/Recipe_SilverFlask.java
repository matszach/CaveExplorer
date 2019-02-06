package com.company.Crafting.PotionsAndElixirs;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PotionsAndElixirs.SilverFlask;
import com.company.Resources.ResourceType;

final public class Recipe_SilverFlask extends CraftingRecipe {
    public Recipe_SilverFlask(){
        super(SilverFlask.class);
        setRequiredResource(ResourceType.SILVER, 5);
    }
}
