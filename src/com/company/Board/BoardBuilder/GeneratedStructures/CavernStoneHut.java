package com.company.Board.BoardBuilder.GeneratedStructures;

import com.company.Tiles.*;

public class CavernStoneHut {

        public static void generateStoneHut(int[][] board, int xRoot, int yRoot){

            int xMin = xRoot - (int)(Math.random()*3) - 2;
            xMin = xMin >= 0 ? xMin : 0;
            int xMax = xRoot + (int)(Math.random()*3) + 2;
            xMax = xMax < board.length ? xMax : board.length-1;
            int yMin = yRoot - (int)(Math.random()*3) - 2;
            yMin = yMin >= 0 ? yMin : 0;
            int yMax = yRoot + (int)(Math.random()*3) + 2;
            yMax = yMax < board[0].length ? yMax : board[0].length-1;

            int floorNum = TileTypes.getNumFromTile(Tile_Floor.class);
            int wallNum = TileTypes.getNumFromTile(Tile_Const_StoneWall.class);
            int crateNum = TileTypes.getNumFromTile(Tile_Obj_ResourceCrate.class);

            for(int x = xMin; x <= xMax; x++){
                for(int y = yMin; y <= yMax; y++){
                    if(x == xMin || x == xMax || y == yMin || y == yMax){
                        if(Math.random() > 0.1){
                            board[x][y] = wallNum;
                        }
                    } else if (x == xRoot && y == yRoot){
                        board[x][y] = crateNum;
                    } else {
                        board[x][y] = floorNum;
                    }

                }
            }
        }

}
