package com.company.Agent.Monster.MonsterAI;

import com.company.Agent.Monster.Monster;
import com.company.ImageBank;

public class EnragedZombie extends Monster {


    @Override
    public void buildDefaultAppearance() {
        setImage(ImageBank.getAgentTiles1());
        setViewByRowAndCol(0,3);
    }

    @Override
    public void buildMeleeAttackAppearance(int i) {
        //setImage(ImageBank.getAgentTiles1());
        setViewByRowAndCol(1+i,3);
    }

    public EnragedZombie(){
        super(7, 0.04);
        buildDefaultAppearance();
        setMonsterAI(new SimpleFollowerAI(this, 8));
        awaken();
    }
}