package com.company.Board.BoardBuilder.GeneratedStructures;

import com.company.Tiles.TileTypes;

public class OreVein {


    public static void spreadInCircle(int[][] board, int blockType, int xRoot, int yRoot, int range, double density){

        int xMin = xRoot - range >= 0 ? xRoot - range : 0;
        int yMin = yRoot - range >= 0 ? yRoot - range : 0;
        int xMax = xRoot + range <= board.length - 1 ? xRoot + range : board.length - 1;
        int yMax = yRoot + range <= board.length - 1 ? yRoot + range : board.length - 1;


        for(int x = xMin ; x<=xMax ; x++){
           for(int y = yMin ; y<=yMax ; y++){
               if (Math.random() < density && Math.sqrt((x-xRoot)*(x-xRoot) + (y-yRoot)*(y-yRoot)) < range+1){
                   board[x][y] = blockType;
               }
           }
        }
    }

    public static void spreadInSquare(int[][] board, int blockType, int xRoot, int yRoot, int range, double density){

        int xMin = xRoot - range >= 0 ? xRoot - range : 0;
        int yMin = yRoot - range >= 0 ? yRoot - range : 0;
        int xMax = xRoot + range <= board.length - 1 ? xRoot + range : board.length - 1;
        int yMax = yRoot + range <= board.length - 1 ? yRoot + range : board.length - 1;


        for(int x = xMin ; x<=xMax ; x++){
            for(int y = yMin ; y<=yMax ; y++){
                if (Math.random() < density){
                    board[x][y] = blockType;
                }
            }
        }
    }

}
