package com.company.Board.BoardBuilder;

import com.company.Board.BoardBuilder.GeneratedStructures.AbandonedMine;

public class StructureGenerator {

    // Generates abandoned mines
    public static void generateMines(int [][] board, double frequency){

        int minX = 100;
        int maxX = board.length - 100;
        int minY = 100;
        int maxY = board[0].length - 100;

        int increment = board.length/5;
        int measure = increment/10;

        for(int x = minX; x < maxX; x+=increment){
            for(int y = minY; y < maxY; y+=increment){
                if(Math.random() < frequency){
                    AbandonedMine.spread(board,x,y,measure);
                }
            }
        }
    }

}
