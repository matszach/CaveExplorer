package com.company.Board.BoardBuilder.GeneratedStructures;

import com.company.GameValues;

import java.util.ArrayList;

public class RootList extends ArrayList {

    @Override
    public boolean add(Object o) {
        if(!(o instanceof StructureRoot)){
            throw new ArrayStoreException();
        }
        return super.add(o);
    }

    @Override
    public boolean contains(Object o) {
        if(o instanceof StructureRoot){
            for(Object obj : this){
                if(obj instanceof StructureRoot){
                    if(((StructureRoot) obj).x == ((StructureRoot) o).x &&
                        ((StructureRoot) obj).y == ((StructureRoot) o).y){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean rootLegal(int [][] board, StructureRoot structureRoot){
        if(structureRoot.x < 0 || structureRoot.y < 0){
            return false;
        } else {
            return structureRoot.x < board.length-1 && structureRoot.y < board[0].length-1;
        }

    }


    private StructureRoot getRandomRoot(){
        int rootInvoked = (int)(Math.random()*size());
        return (StructureRoot)get(rootInvoked);
    }


    private void expandByOne(int[][] board){
        while (true){

            StructureRoot baseRoot = getRandomRoot();
            StructureRoot candidateRoot;

            double randDir = Math.random();

            if(randDir > 0.75){
                candidateRoot = new StructureRoot(baseRoot.x+1, baseRoot.y);
            } else if (randDir > 0.5){
                candidateRoot = new StructureRoot(baseRoot.x-1, baseRoot.y);
            } else if (randDir > 0.25){
                candidateRoot = new StructureRoot(baseRoot.x, baseRoot.y+1);
            } else {
                candidateRoot = new StructureRoot(baseRoot.x, baseRoot.y-1);
            }


            if(rootLegal(board, candidateRoot) && !contains(candidateRoot)){
                add(candidateRoot);
                break;
            }
        }
    }


    public void expandToSize(int[][] board, int targetSize){
        while (size() < targetSize){
            expandByOne(board);
        }
    }


}
