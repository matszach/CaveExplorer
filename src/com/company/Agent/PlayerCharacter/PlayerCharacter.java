package com.company.Agent.PlayerCharacter;

import com.company.Agent.Agent;
import com.company.Animations.ItemGainAnimation;
import com.company.Animations.ResourceGainAnimation;
import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.ImageBank;
import com.company.Items.Item;
import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PlayerCharacter extends Agent {


    private PlayerInventory playerInventory;
    public PlayerInventory getInventory() {
        return playerInventory;
    }


    public void gainResource(int resourceTypeNum, int amount){
        playerInventory.getResource(resourceTypeNum).gain(amount);
        ResourceGainAnimation resAnim = new ResourceGainAnimation(resourceTypeNum, amount);
        resAnim.play();
    }

    public void gainItem(Item item){
        if(playerInventory.hasEmptyItemSlot()){
            playerInventory.addItemsToInventory(item);
            ItemGainAnimation itemAnim = new ItemGainAnimation(item);
            itemAnim.play();
        }
    }

    @Override
    public void buildDefaultAppearance() {
        setImage(ImageBank.getAgentTiles1());
        setViewByRowAndCol(0,0);
    }

    @Override
    public void buildMeleeAttackAppearance(int i) {
        setViewByRowAndCol(1+i,0);
    }

    public void buildDrillingAppearance(int i) {
        setViewByRowAndCol(4+i,0);
    }


    public PlayerCharacter(){
        super();
        playerInventory = new PlayerInventory();
        buildDefaultAppearance();
        setMovementSpeed(0.0625);

    }
}
