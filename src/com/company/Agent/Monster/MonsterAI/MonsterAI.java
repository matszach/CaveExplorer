package com.company.Agent.Monster.MonsterAI;

import com.company.Agent.Monster.Monster;
import com.company.CaveExplorer;
import com.company.Tiles.Tile;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;

abstract public class MonsterAI extends AnimationTimer {

    // references the monster, needed for handle method
    Monster monster;

    // how close does the player have to be to the monster for it to start to pursue him/her
    int searchRange;



    public MonsterAI(Monster monster, int searchRange){
        this.monster = monster;
        this.searchRange = searchRange;
    }
}
