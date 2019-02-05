package com.company.Items;

import com.company.Items.BlockPlacers.Trowel;
import com.company.Items.Daggers.BloodRubyDagger;
import com.company.Items.Daggers.CobaltDagger;
import com.company.Items.Daggers.CopperDagger;
import com.company.Items.Daggers.IronDagger;
import com.company.Items.Drills.BloodRubyDrill;
import com.company.Items.Drills.CobaltDrill;
import com.company.Items.Drills.CopperDrill;
import com.company.Items.Drills.IronDrill;
import com.company.Items.PlaceableObjects.WoodenSupport;
import com.company.Items.PotionsAndElixirs.PotionOfHealing;
import com.company.Items.Spears.BloodRubySpear;
import com.company.Items.Spears.CobaltSpear;
import com.company.Items.Spears.CopperSpear;
import com.company.Items.Spears.IronSpear;
import com.company.Items.Swords.BloodRubySword;
import com.company.Items.Swords.CobaltSword;
import com.company.Items.Swords.CopperSword;
import com.company.Items.Swords.IronSword;

import java.util.HashMap;
import java.util.Map;

final public class ItemTypes {

    // item type map
    private static Map<Integer, Class<? extends Item>> itemTypeMap = new HashMap<>();
    public static Map<Integer, Class<? extends Item>> getItemTypeMap() {
        return itemTypeMap;
    }

    public static Item getItemFromNum(int num){
        try {
            return getItemTypeMap().get(num).newInstance();
        } catch (Exception e){
            return null;
        }
    }


    public static int getNumFromItem(Class c){
        for(int i : getItemTypeMap().keySet()){
            if(getItemTypeMap().get(i).equals(c)){
                return i;
            }
        }
        return 0;
    }

    public ItemTypes(){
        getItemTypeMap().put(0, CopperDrill.class);
        getItemTypeMap().put(1, CopperDagger.class);
        getItemTypeMap().put(2, CopperSword.class);
        getItemTypeMap().put(3, CopperSpear.class);
        getItemTypeMap().put(4, IronDrill.class);
        getItemTypeMap().put(5, IronDagger.class);
        getItemTypeMap().put(6, IronSword.class);
        getItemTypeMap().put(7, IronSpear.class);
        getItemTypeMap().put(8, CobaltDrill.class);
        getItemTypeMap().put(9, CobaltDagger.class);
        getItemTypeMap().put(10, CobaltSword.class);
        getItemTypeMap().put(11, CobaltSpear.class);
        getItemTypeMap().put(12, BloodRubyDrill.class);
        getItemTypeMap().put(13, BloodRubyDagger.class);
        getItemTypeMap().put(14, BloodRubySword.class);
        getItemTypeMap().put(15, BloodRubySpear.class);
        getItemTypeMap().put(16, Trowel.class);
        getItemTypeMap().put(17, WoodenSupport.class);


        getItemTypeMap().put(20, PotionOfHealing.class);

    }
}