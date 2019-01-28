package com.company.Agent.Monster.MonsterAI;


import com.company.Agent.Monster.Monster;
import com.company.Agent.Monster.MonsterAI.AStarPathfinder.AStarPathfinder;
import com.company.Agent.Monster.MonsterAI.AStarPathfinder.AStarTileNode;
import com.company.CaveExplorer;
import com.company.Tiles.Tile;

import java.util.ArrayList;

public class AStarFollowerAI extends MonsterAI {

    @Override
    public void handle(long now) {

        int xStart = monster.roundTileX();
        int yStart = monster.roundTileY();
        int xEnd = CaveExplorer.getPlayerCharacter().roundTileX();
        int yEnd = CaveExplorer.getPlayerCharacter().roundTileY();

        if(Math.sqrt((xStart-xEnd)*(xStart-xEnd)+(yStart-yEnd)*(yStart-yEnd)) > searchRange){
            return;
        }





        // might be moved somewhere else
        monster.toFront();
    }

    public AStarFollowerAI(Monster monster, int searchRange){
        super(monster, searchRange);
    }

}
