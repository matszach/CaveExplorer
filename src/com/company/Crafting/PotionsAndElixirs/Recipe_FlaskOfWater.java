package com.company.Crafting.PotionsAndElixirs;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PotionsAndElixirs.FlaskOfWater;
import com.company.Items.PotionsAndElixirs.SilverFlask;

final public class Recipe_FlaskOfWater extends CraftingRecipe {
    public Recipe_FlaskOfWater(){
        super(FlaskOfWater.class);
        getRequiredItems().add(SilverFlask.class);
    }
}
