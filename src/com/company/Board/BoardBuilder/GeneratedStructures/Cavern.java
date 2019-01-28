package com.company.Board.BoardBuilder.GeneratedStructures;

import com.company.Tiles.TileTypes;
import com.company.Tiles.Tile_Floor;

import java.util.ArrayList;

public class Cavern {

    public enum SpreadDir {L, LU, U, RU, R, RD, D, LD}

    private static SpreadDir getRandomDir(){
        return SpreadDir.values()[(int)(Math.random()*(SpreadDir.values().length))];
    }
    private static SpreadDir getRelatedDir(SpreadDir spreadDir){

        int spreadDirNum = 0;

        for(int i = 0; i < SpreadDir.values().length; i++){
            if(SpreadDir.values()[i].equals(spreadDir)){
                spreadDirNum = i;
                break;
            }
        }

        double r = Math.random();

        if(r > 0.75){
            spreadDirNum++;
        } else if (r > 0.5){
            spreadDirNum += 2;
        } else if (r > 0.25){
            spreadDirNum -= 2;
        } else {
            spreadDirNum --;
        }

        if(spreadDirNum > SpreadDir.values().length - 1){
            spreadDirNum = spreadDirNum - SpreadDir.values().length + 1;
        } else if (spreadDirNum < 0){
            spreadDirNum = SpreadDir.values().length - 1 + spreadDirNum;
        }

        return SpreadDir.values()[spreadDirNum];
    }

    private static int stepX(int x, SpreadDir dir){
        switch (dir){
            case L: case LD: case LU: x -= (int)(Math.random()*2)+1; break;
            case R: case RD: case RU: x += (int)(Math.random()*2)+1; break;
        }
        return x;
    }

    private static int stepY(int y, SpreadDir dir){
        switch (dir){
            case U: case LU: case RU: y -= (int)(Math.random()*2)+1; break;
            case D: case LD: case RD: y += (int)(Math.random()*2)+1; break;
        }
        return y;
    }


    private static void spreadStep(int[][] board, int xCentral , int yCentral){

        int xMin = xCentral - (int)(Math.random()*2) - 1;
        int yMin = yCentral - (int)(Math.random()*2) - 1;
        int xMax = xCentral + (int)(Math.random()*2) + 1;
        int yMax = yCentral + (int)(Math.random()*2) + 1;

        int floorNum = TileTypes.getNumFromTile(Tile_Floor.class);

        for(int x = xMin; x <= xMax; x++){
            for(int y = yMin; y <= yMax; y++){
                if(Math.random() > 0.05 && !((x == xMin || x == xMax) && (y == yMin || y == yMax))){
                    board[x][y] = floorNum;
                }
            }
        }
    }


    public static void spread(int [][] board, int x , int y, int length, SpreadDir mainDirection, ArrayList<StructureRoot> structureRoots){
        double divergeChance = 0;
        double changeDirectionChance = 0;
        double cavernStructure = 0;
        for(int i = 0; i < length; i++){

            if(x < 10 || x > board.length - 11){
                break;
            }
            if(y < 10 || y > board[0].length - 11){
                break;
            }

            spreadStep(board, x, y);

            x = stepX(x, mainDirection);
            y = stepY(y, mainDirection);

            // Chance for a new, shorter cavern to spawn from the current one
            divergeChance += 0.0005;
            if(Math.random() < divergeChance){
                divergeChance = 0.0;
                Cavern.spread(board,x,y,length*8/10, getRandomDir(), structureRoots);
            }

            // Chance for a stone hut/lava pool structure to generate in the cavern
            cavernStructure += 0.001;
            if(Math.random() < cavernStructure){
                cavernStructure = 0;
                int xRoot = Math.random() > 0.5 ? x + 5 : x - 5;
                xRoot = xRoot > 0 ? xRoot : 1;
                xRoot = xRoot < board.length ? xRoot : board.length-1;
                int yRoot = Math.random() > 0.5 ? y + 5 : y - 5;
                yRoot = yRoot > 0 ? yRoot : 1;
                yRoot = yRoot < board[0].length ? yRoot : board[0].length-1;
                structureRoots.add(new StructureRoot(xRoot,yRoot));
            }


            // Chance for the cavern to change its direction
            changeDirectionChance += 0.009;
            if(Math.random() < changeDirectionChance){
                changeDirectionChance = 0.0;
                mainDirection = getRelatedDir(mainDirection);
            }
        }

    }
    public static void spread(int [][] board, int x , int y, int length, ArrayList<StructureRoot> structureRoots){
        spread(board,x,y,length,getRandomDir(),structureRoots);
    }
}
