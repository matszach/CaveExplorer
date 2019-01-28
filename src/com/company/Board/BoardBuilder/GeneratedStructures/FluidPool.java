package com.company.Board.BoardBuilder.GeneratedStructures;


public class FluidPool {

    public static void generateFluidPool(int[][] board, int xRoot, int yRoot, int fluidType){

        RootList rootList = new RootList();
        rootList.add(new StructureRoot(xRoot, yRoot));

        rootList.expandToSize(board, (int)(Math.random()*50)+50); // fixme the size doesn't entirely work, the pools end up smaller

        for(Object object : rootList){
            if(object instanceof StructureRoot){
                board[((StructureRoot) object).x][((StructureRoot) object).y] = fluidType;
            }
        }

    }

}
