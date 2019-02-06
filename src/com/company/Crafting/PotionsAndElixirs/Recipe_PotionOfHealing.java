package com.company.Crafting.PotionsAndElixirs;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PotionsAndElixirs.FlaskOfWater;
import com.company.Items.PotionsAndElixirs.Potion;
import com.company.Items.PotionsAndElixirs.PotionOfHealing;
import com.company.Items.PotionsAndElixirs.SilverFlask;
import com.company.Resources.ResourceType;

final public class Recipe_PotionOfHealing extends CraftingRecipe {
    public Recipe_PotionOfHealing(){
        super(PotionOfHealing.class);
        setRequiredResource(ResourceType.GOLD, 10);
        getRequiredItems().add(FlaskOfWater.class);
    }
}
