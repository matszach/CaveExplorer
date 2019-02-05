package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PlaceableObjects.WoodenSupport;
import com.company.Items.Spears.BloodRubySpear;
import com.company.Items.Spears.CobaltSpear;
import com.company.Items.Spears.CopperSpear;
import com.company.Items.Spears.IronSpear;
import com.company.Resources.ResourceType;

final public class Recipe_BloodRubySpear extends CraftingRecipe {
    public Recipe_BloodRubySpear(){
        super(BloodRubySpear.class);
        setRequiredResource(ResourceType.BLOOD_RUBY, 15);
        getRequiredItems().add(CobaltSpear.class);
        getRequiredItems().add(WoodenSupport.class);
    }
}
