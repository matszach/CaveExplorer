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
        setViewport(new Rectangle2D(1,1,30,30));
    }

    public void buildDrillingAppearance(int i) {
        int x = (i+1)*32+1;
        setImage(ImageBank.getAgentTiles1());
        setViewport(new Rectangle2D(x,1,30,30));
    }


    public PlayerCharacter(){
        super();
        playerInventory = new PlayerInventory();
        buildDefaultAppearance();
        setMovementSpeed(0.0625);

    }
}
