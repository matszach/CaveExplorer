package com.company.Crafting.Tools;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Drills.BloodRubyDrill;
import com.company.Items.Drills.CobaltDrill;
import com.company.Resources.ResourceType;

final public class Recipe_BloodRubyDrill extends CraftingRecipe {
    public Recipe_BloodRubyDrill(){
        super(BloodRubyDrill.class);
        setRequiredResource(ResourceType.BLOOD_RUBY,20);
        getRequiredItems().add(CobaltDrill.class);
    }
}