package com.company.Board.BoardBuilder.GeneratedStructures;

import com.company.Tiles.TileTypes;
import com.company.Tiles.Tile_Const_WoodenSupport;
import com.company.Tiles.Tile_Floor;

import java.util.ArrayList;

public class AbandonedMine {

    private static int var(int measure){
        return measure/2 + (int)(Math.random()*measure/2);
    }

    private static void drawFromRoot(int[][]board, StructureRoot root, int measure){
        int measure_x = var(measure);
        int measure_y = var(measure);
        int xMin = root.x - measure_x > 10 ? root.x - measure_x : 10;
        int xMax = root.x + measure_x < board.length - 10 ? root.x + measure_x : board.length - 10;
        int yMin = root.y - measure_y > 10 ? root.y - measure_y : 10;
        int yMax = root.y + measure_y < board[0].length - 10 ? root.y + measure_y : board[0].length - 10;

        int floorNum = TileTypes.getNumFromTile(Tile_Floor.class);
        int woodSupportNum = TileTypes.getNumFromTile(Tile_Const_WoodenSupport.class);

        for(int x = xMin; x < xMax; x++){
            for(int y = root.y - 2; y <= root.y + 2; y++){
                if((y==root.y-2 || y==root.y+2)&& x%4==0){
                    board[x][y] = woodSupportNum;
                } else {
                    board[x][y] = floorNum;
                }
            }
        }
        for(int y = yMin; y < yMax; y++){
            for(int x = root.x - 2; x <= root.x + 2; x++){
                if((x==root.x-2 || x==root.x+2)&& y%4==0){
                    board[x][y] = woodSupportNum;
                } else {
                    board[x][y] = floorNum;
                }
            }
        }
    }

    public static void spread(int [][] board, int xRoot , int yRoot, int measure){

        ArrayList<StructureRoot> structureRoots = new ArrayList<>();

        int rand_measure = var(measure);

        for(int x = xRoot - measure; x <= xRoot + measure; x += rand_measure){
            if(x > 10 + measure && x < board.length - 10 - measure){
                for(int y = yRoot - measure; y <= yRoot + measure; y += rand_measure){
                    if(y > 10 + measure && y < board[0].length - 10 - measure){
                        if(Math.random() > 0.25){
                            structureRoots.add(new StructureRoot(x,y));
                        }
                    }
                }
            }

        }

        for(StructureRoot root : structureRoots){
            drawFromRoot(board,root,measure);
        }
    }

}
