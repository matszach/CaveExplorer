package com.company.Agent.Monster;

import com.company.Agent.Monster.MonsterAI.SimpleFollowerAI;
import com.company.ImageBank;
import javafx.geometry.Rectangle2D;

public class Zombie extends Monster{

    @Override
    public void buildDefaultAppearance() {
        setImage(ImageBank.getAgentTiles1());
        setViewport(new Rectangle2D(1,33,30,30));
    }

    public Zombie(){
        super();
        buildDefaultAppearance();
        setMovementSpeed(0.02);
        setMonsterAI(new SimpleFollowerAI(this, 8));
        awaken();
    }
}
