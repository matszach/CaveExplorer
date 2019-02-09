package com.company.Items;

import com.company.HUD.GameOverWindow;
import com.company.Items.BlockPlacers.Trowel;
import com.company.Items.Daggers.BloodRubyDagger;
import com.company.Items.Daggers.CobaltDagger;
import com.company.Items.Daggers.CopperDagger;
import com.company.Items.Daggers.IronDagger;
import com.company.Items.Drills.BloodRubyDrill;
import com.company.Items.Drills.CobaltDrill;
import com.company.Items.Drills.CopperDrill;
import com.company.Items.Drills.IronDrill;
import com.company.Items.PlaceableObjects.*;
import com.company.Items.PotionsAndElixirs.*;
import com.company.Items.Spears.BloodRubySpear;
import com.company.Items.Spears.CobaltSpear;
import com.company.Items.Spears.CopperSpear;
import com.company.Items.Spears.IronSpear;
import com.company.Items.Staves.GoldStaff;
import com.company.Items.Staves.PlatinumStaff;
import com.company.Items.Staves.SilverStaff;
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

        for(Integer i : getItemTypeMap().keySet()){
            if(getItemTypeMap().get(i).equals(c)){
                return i;
            }
        }

        return 0;
    }

    public ItemTypes(){
        getItemTypeMap().put(1, CopperDrill.class);
        getItemTypeMap().put(2, CopperDagger.class);
        getItemTypeMap().put(3, CopperSword.class);
        getItemTypeMap().put(4, CopperSpear.class);
        getItemTypeMap().put(5, IronDrill.class);
        getItemTypeMap().put(6, IronDagger.class);
        getItemTypeMap().put(7, IronSword.class);
        getItemTypeMap().put(8, IronSpear.class);
        getItemTypeMap().put(9, CobaltDrill.class);
        getItemTypeMap().put(10, CobaltDagger.class);
        getItemTypeMap().put(11, CobaltSword.class);
        getItemTypeMap().put(12, CobaltSpear.class);
        getItemTypeMap().put(13, BloodRubyDrill.class);
        getItemTypeMap().put(14, BloodRubyDagger.class);
        getItemTypeMap().put(15, BloodRubySword.class);
        getItemTypeMap().put(16, BloodRubySpear.class);
        getItemTypeMap().put(17, Trowel.class);
        getItemTypeMap().put(18, WoodenSupport.class);
        getItemTypeMap().put(19, SilverFlask.class);
        getItemTypeMap().put(20, FlaskOfWater.class);
        getItemTypeMap().put(21, PotionOfHealing.class);
        getItemTypeMap().put(22, ElixirOfSpeed.class);
        getItemTypeMap().put(23, ElixirOfRegeneration.class);
        getItemTypeMap().put(24, ElixirOfStoneSkin.class);
        getItemTypeMap().put(25, Workshop.class);
        getItemTypeMap().put(26, AlchemyLab.class);
        getItemTypeMap().put(27, SilverStaff.class);
        getItemTypeMap().put(28, GoldStaff.class);
        getItemTypeMap().put(29, PlatinumStaff.class);
        getItemTypeMap().put(30, Fireplace.class);
        getItemTypeMap().put(31, EnchantingStation.class);


    }
}