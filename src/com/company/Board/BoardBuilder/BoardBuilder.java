package com.company.Board.BoardBuilder;

import com.company.Board.Board;
import com.company.GameValues;


public class BoardBuilder {

    private static TerrainGenerator terrainGenerator = new TerrainGenerator();
    private static StructureGenerator structureGenerator = new StructureGenerator();

    // "true" value will prevent a structure spawning too close to another structure
    private static boolean[][] occupied;

    public static int[][] generateGrid(int sideLengthInTiles, double oreAmount, double terrainAmount, double structureAmount){

        int [][] grid = new int[sideLengthInTiles][sideLengthInTiles];
        occupied = new boolean[sideLengthInTiles][sideLengthInTiles];

        double oreAmtMod = oreAmount/50;
        double terAmtMod = terrainAmount/50;
        double strAmtMod = structureAmount/50;

        TerrainGenerator.generateStone(grid, 0.985);

        TerrainGenerator.generateCoalOre(grid,0.0004*oreAmtMod,10);
        TerrainGenerator.generateCopperOre(grid, 0.0004*oreAmtMod,10);
        TerrainGenerator.generateIronOre(grid, 0.0003*oreAmtMod, 10);
        TerrainGenerator.generateSulfurOre(grid,0.0003*oreAmtMod,10);
        TerrainGenerator.generateSilverOre(grid, 0.00025*oreAmtMod, 50);
        TerrainGenerator.generateGoldOre(grid, 0.00025*oreAmtMod, 50);
        TerrainGenerator.generatePlatinumOre(grid, 0.0002*oreAmtMod, 50);
        TerrainGenerator.generateCobaltOre(grid, 0.0002*oreAmtMod, 50);
        TerrainGenerator.generateBloodRubyOre(grid, 0.00015*oreAmtMod,100);

        TerrainGenerator.generateCaverns(grid, 0.65*terAmtMod);

        TerrainGenerator.generateBedrock(grid, GameValues.getBedrockWidth());

        StructureGenerator.generateMines(grid,0.4*strAmtMod);

        return grid;
    }


    // the method that combines all the previous ones, to build the game-board
    public static Board buildBoard(int sideLengthInTiles, double oreAmount, double terrainAmount, double structureAmount){
        return new Board(generateGrid(sideLengthInTiles, oreAmount, terrainAmount, structureAmount));
    }

}
