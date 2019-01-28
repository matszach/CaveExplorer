package com.company.Agent.Monster.MonsterAI.AStarPathfinder;

public class AStarTileNode {

    public int x;
    public int y;

    public double hVal;
    public double gVal;

    public double getFCost(){
        return hVal+gVal;
    }

    public boolean isBlocked;

    @Override
    public boolean equals(Object obj) {
        return x == ((AStarTileNode)obj).x && y == ((AStarTileNode)obj).y;
    }

    // Constructor 1, for non-blocked nodes
    public AStarTileNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Constructor 2, for blocked nodes
    public AStarTileNode(int x, int y, boolean isBlocked) {
        this.x = x;
        this.y = y;
        this.isBlocked = isBlocked;
    }
}
