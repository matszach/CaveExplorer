package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Daggers.BloodRubyDagger;
import com.company.Items.Daggers.CobaltDagger;
import com.company.Resources.ResourceType;

final public class Recipe_BloodRubyDagger extends CraftingRecipe {
    public Recipe_BloodRubyDagger(){
        super(BloodRubyDagger.class);
        setRequiredResource(ResourceType.BLOOD_RUBY, 5);
        getRequiredItems().add(CobaltDagger.class);
    }
}