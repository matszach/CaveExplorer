package com.company.Board.BoardBuilder;
import com.company.Board.BoardBuilder.GeneratedStructures.*;
import com.company.Tiles.*;

import java.util.ArrayList;

public class TerrainGenerator {

    // Generates Stone Wall and Stone Floor - the 2 most basic/default tiles
    public static void generateStoneAndGravel(int [][] board, double density){

        int stoneNum = TileTypes.getNumFromTile(Tile_Stone.class);
        int gravelNum = TileTypes.getNumFromTile(Tile_Gravel.class);
        double stonePercentage = 0.8;

        for(int x = 0; x < board.length; x++){
            for (int y = 0; y < board[0].length; y++){
                if(Math.random() < density) {
                    if(Math.random() < stonePercentage){
                        board[x][y] = stoneNum;
                    } else {
                        board[x][y] = gravelNum;
                    }
                }
            }
        }
    }

    // Generates Ores
    public static void generateCoalOre(int [][] board, double richness, int border){

        int coalOreNum = TileTypes.getNumFromTile(Tile_Ore_Coal.class);

        for(int x = border; x < board.length - border - 1; x++){
            for (int y = border; y < board[0].length - border; y++){
                if(Math.random() < richness){
                    double veinSize = Math.random();
                    if(veinSize > 0.95){
                        OreVein.spreadInCircle(board,coalOreNum,x,y,(int)(Math.random()*3)+3,0.4);
                    } else if (veinSize > 0.65){
                        OreVein.spreadInCircle(board,coalOreNum,x,y,(int)(Math.random()*2)+2,0.6);
                    } else {
                        OreVein.spreadInCircle(board,coalOreNum,x,y,1,0.6);
                    }
                }
            }
        }

    }
    public static void generateCopperOre(int [][] board, double richness, int border){

        int copperOreNum = TileTypes.getNumFromTile(Tile_Ore_Copper.class);

        for(int x = border; x < board.length - border - 1; x++){
            for (int y = border; y < board[0].length - border; y++){
                if(Math.random() < richness){
                    double veinSize = Math.random();
                    if(veinSize > 0.95){
                        OreVein.spreadInCircle(board,copperOreNum,x,y,(int)(Math.random()*3)+3,0.4);
                    } else if (veinSize > 0.65){
                        OreVein.spreadInCircle(board,copperOreNum,x,y,(int)(Math.random()*2)+2,0.6);
                    } else {
                        OreVein.spreadInCircle(board,copperOreNum,x,y,1,0.6);
                    }
                }
            }
        }

    }
    public static void generateIronOre(int [][] board, double richness, int border){

        int ironOreNum = TileTypes.getNumFromTile(Tile_Ore_Iron.class);

        for(int x = border; x < board.length - border - 1; x++){
            for (int y = border; y < board[0].length - border; y++){
                if(Math.random() < richness){
                    double veinSize = Math.random();
                    if(veinSize > 0.95){
                        OreVein.spreadInCircle(board,ironOreNum,x,y,(int)(Math.random()*3)+2,0.4);
                    } else if (veinSize > 0.65){
                        OreVein.spreadInCircle(board,ironOreNum,x,y,(int)(Math.random()*2)+2,0.6);
                    } else {
                        OreVein.spreadInCircle(board,ironOreNum,x,y,1,0.6);
                    }
                }
            }
        }

    }
    public static void generateSulfurOre(int [][] board, double richness, int border){

        int sulfurOreNum = TileTypes.getNumFromTile(Tile_Ore_Sulfur.class);

        for(int x = border; x < board.length - border - 1; x++){
            for (int y = border; y < board[0].length - border; y++){
                if(Math.random() < richness){
                    double veinSize = Math.random();
                    if(veinSize > 0.95){
                        OreVein.spreadInCircle(board,sulfurOreNum,x,y,(int)(Math.random()*3)+2,0.4);
                    } else if (veinSize > 0.65){
                        OreVein.spreadInCircle(board,sulfurOreNum,x,y,(int)(Math.random()*2)+2,0.6);
                    } else {
                        OreVein.spreadInCircle(board,sulfurOreNum,x,y,1,0.6);
                    }
                }
            }
        }

    }
    public static void generateSilverOre(int [][] board, double richness, int border){

        int silverOreNum = TileTypes.getNumFromTile(Tile_Ore_Silver.class);

        for(int x = border; x < board.length - border - 1; x++){
            for (int y = border; y < board[0].length - border; y++){
                if(Math.random() < richness){
                    double veinSize = Math.random();
                    if(veinSize > 0.95){
                        OreVein.spreadInCircle(board,silverOreNum,x,y,(int)(Math.random()*2)+3,0.3);
                    } else if (veinSize > 0.65){
                        OreVein.spreadInCircle(board,silverOreNum,x,y,2,0.5);
                    } else {
                        OreVein.spreadInCircle(board,silverOreNum,x,y,1,0.5);
                    }
                }
            }
        }

    }
    public static void generateGoldOre(int [][] board, double richness, int border){

        int goldOreNum = TileTypes.getNumFromTile(Tile_Ore_Gold.class);

        for(int x = border; x < board.length - border - 1; x++){
            for (int y = border; y < board[0].length - border; y++){
                if(Math.random() < richness){
                    double veinSize = Math.random();
                    if(veinSize > 0.95){
                        OreVein.spreadInCircle(board,goldOreNum,x,y,(int)(Math.random()*2)+3,0.3);
                    } else if (veinSize > 0.65){
                        OreVein.spreadInCircle(board,goldOreNum,x,y,2,0.5);
                    } else {
                        OreVein.spreadInCircle(board,goldOreNum,x,y,1,0.5);
                    }
                }
            }
        }

    }
    public static void generatePlatinumOre(int [][] board, double richness, int border){

        int platOreNum = TileTypes.getNumFromTile(Tile_Ore_Platinum.class);

        for(int x = border; x < board.length - border - 1; x++){
            for (int y = border; y < board[0].length - border; y++){
                if(Math.random() < richness){
                    double veinSize = Math.random();
                    if(veinSize > 0.95){
                        OreVein.spreadInCircle(board,platOreNum,x,y,(int)(Math.random()*2)+3,0.2);
                    } else if (veinSize > 0.65){
                        OreVein.spreadInCircle(board,platOreNum,x,y,2,0.4);
                    } else {
                        OreVein.spreadInCircle(board,platOreNum,x,y,1,0.4);
                    }
                }
            }
        }

    }
    public static void generateCobaltOre(int [][] board, double richness, int border){

        int cobaltOreNum = TileTypes.getNumFromTile(Tile_Ore_Cobalt.class);

        for(int x = border; x < board.length - border - 1; x++){
            for (int y = border; y < board[0].length - border; y++){
                if(Math.random() < richness){
                    double veinSize = Math.random();
                    if(veinSize > 0.95){
                        OreVein.spreadInCircle(board,cobaltOreNum,x,y,(int)(Math.random()*2)+3,0.2);
                    } else if (veinSize > 0.65){
                        OreVein.spreadInCircle(board,cobaltOreNum,x,y,2,0.4);
                    } else {
                        OreVein.spreadInCircle(board,cobaltOreNum,x,y,1,0.4);
                    }
                }
            }
        }

    }
    public static void generateBloodRubyOre(int [][] board, double richness, int border){

        int bloodRubyOreNum = TileTypes.getNumFromTile(Tile_Ore_BloodRuby.class);

        for(int x = border; x < board.length - border - 1; x++){
            for (int y = border; y < board[0].length - border; y++){
                if(Math.random() < richness){
                    double veinSize = Math.random();
                    if(veinSize > 0.95){
                        OreVein.spreadInCircle(board,bloodRubyOreNum,x,y,(int)(Math.random()*2)+3,0.15);
                    } else if (veinSize > 0.65){
                        OreVein.spreadInCircle(board,bloodRubyOreNum,x,y,2,0.3);
                    } else {
                        OreVein.spreadInCircle(board,bloodRubyOreNum,x,y,1,0.3);
                    }
                }
            }
        }

    }


    // Generate Caverns
    public static void generateCaverns(int [][] board, double expansiveness){

        int cavernSpread = board.length/50;
        int cavernLengthMod = board.length/75;
        ArrayList<StructureRoot> structureRoots = new ArrayList<>();

        for (int x = 10; x < board.length - 15; x+=(int)(Math.random()*2*cavernSpread)){
            for (int y = 10; y < board[0].length - 15; y+=(int)(Math.random()*2*cavernSpread)){
                Cavern.spread(board,x,y,(int)((cavernLengthMod+Math.random()*cavernLengthMod)*expansiveness), structureRoots);
            }
        }

        for(StructureRoot structureRoot : structureRoots){
            double strNum = Math.random();
            if(strNum > 0.6){
                CavernStoneHut.generateStoneHut(board,structureRoot.x, structureRoot.y);
            } else if(strNum > 0.3){
                FluidPool.generateFluidPool(board,structureRoot.x, structureRoot.y, TileTypes.getNumFromTile(Tile_Fluid_Lava.class));
            } else {
                FluidPool.generateFluidPool(board,structureRoot.x, structureRoot.y, TileTypes.getNumFromTile(Tile_Fluid_Water.class));
            }

        }

    }

    // Generates Bedrock on the edges of the map
    public static void generateBedrock(int[][] tileGrid, int width) {

        int bedrockNum = TileTypes.getNumFromTile(Tile_Bedrock.class);

        for(int x = 0; x < width; x++){
            for (int y = 0; y < tileGrid[0].length; y++){
                tileGrid[x][y] = bedrockNum;
            }
        }
        for(int x = tileGrid.length-width; x < tileGrid.length; x++){
            for (int y = 0; y < tileGrid[0].length; y++){
                tileGrid[x][y] = bedrockNum;
            }
        }
        for (int y = 0; y < width; y++){
            for (int x = 0; x < tileGrid.length; x++){
                tileGrid[x][y] = bedrockNum;
            }
        }
        for (int y = tileGrid[0].length-width; y < tileGrid[0].length; y++){
            for (int x = 0; x < tileGrid.length; x++){
                tileGrid[x][y] = bedrockNum;
            }
        }
    }



}
