package com.company;

import java.io.PrintWriter;

public final class TxtWorldStatsGenerator {

    private TxtWorldStatsGenerator instance = new TxtWorldStatsGenerator();

    private static  PrintWriter writer;

    private static long[] tileAmountGenerator(int[][]tileTypes){
        long[] tileAmount = new long[14];
        for(int x = 0; x < tileTypes.length; x++){
            for(int y = 0; y < tileTypes[0].length; y++){
                tileAmount[tileTypes[x][y]] += 1;
            }
        }
        return tileAmount;

    }

    public static void printWorldStats(int[][] tileTypes){
        try{
            writer = new PrintWriter("WorldStatsDestination\\worldStats.txt", "UTF-8");
        } catch (Exception e){ }

        long[] tileAmount = tileAmountGenerator(tileTypes);

        for(long num : tileAmount){
            writer.println(num);
        }

        writer.close();
    }

    private TxtWorldStatsGenerator(){

    }
}
