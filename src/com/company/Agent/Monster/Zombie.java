package com.company.Agent.Monster;

import com.company.Agent.Monster.MonsterAI.SimpleFollowerAI;
import com.company.ImageBank;
import javafx.geometry.Rectangle2D;

public class Zombie extends Monster{


    @Override
    public void buildDefaultAppearance() {
        setImage(ImageBank.getAgentTiles1());
        setViewByRowAndCol(0,1);
    }

    @Override
    public void buildMeleeAttackAppearance(int i) {
        //setImage(ImageBank.getAgentTiles1());
        setViewByRowAndCol(1+i,1);
    }

    public Zombie(){
        super();
        buildDefaultAppearance();
        setMovementSpeed(0.02);
        setMonsterAI(new SimpleFollowerAI(this, 8));
        awaken();
    }
}
