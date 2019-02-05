package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Swords.BloodRubySword;
import com.company.Items.Swords.CobaltSword;
import com.company.Resources.ResourceType;

final public class Recipe_BloodRubySword extends CraftingRecipe {
    public Recipe_BloodRubySword(){
        super(BloodRubySword.class);
        setRequiredResource(ResourceType.BLOOD_RUBY, 15);
        getRequiredItems().add(CobaltSword.class);
    }
}