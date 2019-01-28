package com.company.Tiles;

import java.util.HashMap;
import java.util.Map;

public final class TileTypes {

    // tile type map
    private static Map<Integer, Class> tileTypeMap = new HashMap<>();
    public static Map<Integer, Class> getTileTypeMap() {
        return tileTypeMap;
    }

    public static Tile getTileFromNum(int num){
        try {
            return (Tile)getTileTypeMap().get(num).newInstance();
        } catch (Exception e){
            return null;
        }
    }


    public static int getNumFromTile(Class c){
        for(int i : getTileTypeMap().keySet()){
            if(getTileTypeMap().get(i).equals(c)){
                return i;
            }
        }
        return 0;
    }

    public TileTypes(){
        getTileTypeMap().put(0, Tile_Floor.class);
        getTileTypeMap().put(1, Tile_Stone.class);
        getTileTypeMap().put(2, Tile_Ore_Iron.class);
        getTileTypeMap().put(3, Tile_Bedrock.class);
        getTileTypeMap().put(4, Tile_Const_StoneWall.class);
        getTileTypeMap().put(5, Tile_Ore_Platinum.class);
        getTileTypeMap().put(6, Tile_Const_WoodenSupport.class);
        getTileTypeMap().put(7, Tile_Ore_Coal.class);
        getTileTypeMap().put(8, Tile_Ore_Copper.class);
        getTileTypeMap().put(9, Tile_Ore_Silver.class);
        getTileTypeMap().put(10,Tile_Ore_Gold.class);
        getTileTypeMap().put(11, Tile_Ore_Cobalt.class);
        getTileTypeMap().put(12, Tile_Ore_BloodRuby.class);
        getTileTypeMap().put(13, Tile_Ore_Sulfur.class);
        getTileTypeMap().put(14, Tile_Fluid_Water.class);
        getTileTypeMap().put(15, Tile_Fluid_Lava.class);
        getTileTypeMap().put(16, Tile_Obj_ResourceCrate.class);
    }

}
