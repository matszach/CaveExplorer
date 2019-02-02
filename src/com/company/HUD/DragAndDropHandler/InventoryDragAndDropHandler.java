package com.company.HUD.DragAndDropHandler;

import com.company.Agent.Agent;
import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.Items.Item;
import com.company.MouseInputHandler;
import com.company.Scenes.MainGameScene;
import com.company.StageResizeListener;
import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.awt.*;


public class InventoryDragAndDropHandler {

    // instance
    private static InventoryDragAndDropHandler i = new InventoryDragAndDropHandler();

    // the inventory window is open -> drag and drop is active
    private static boolean active;
    public static void setActive(boolean active) {
        InventoryDragAndDropHandler.active = active;
    }
    public static boolean isActive() {
        return active;
    }

    // selected item (item dragged from)
    private static int selectedItemRow;
    private static int selectedItemCol;
    private static boolean selectedItemPresent;

    // targeted item (item / slot dragged to)
    private static int targetedItemRow;
    private static int targetedItemCol;
    private static boolean targetedItemPresent;



    // sets the location of the selected item
    public static void readySelectedItem(int row, int col, ImageView imageViewToImitate){
        if(isActive() && CaveExplorer.getPlayerCharacter().getInventory().getItemsInInventory()[col][row] != null){
            selectedItemRow = row;
            selectedItemCol = col;
            selectedItemPresent = true;
            launchAnimation(imageViewToImitate);
        }
    }

    public static void unreadySelectedItem(){
        selectedItemPresent = false;
    }

    // sets the location of the targeted item / slot
    public static void readyTargetedItem(int row, int col){
        targetedItemRow = row;
        targetedItemCol = col;
        targetedItemPresent = true;
    }

    public static void unreadyTargetedItem(){
        targetedItemPresent = false;
    }


    // checks if the items can be swapped
    public static void swapIfReady(){
        if(selectedItemPresent && targetedItemPresent){
            Item selectedItem = CaveExplorer.getPlayerCharacter().getInventory().getItemsInInventory()[selectedItemCol][selectedItemRow];
            Item targetedItem = CaveExplorer.getPlayerCharacter().getInventory().getItemsInInventory()[targetedItemCol][targetedItemRow];
            CaveExplorer.getPlayerCharacter().getInventory().putItemInSlot(selectedItem, targetedItemCol, targetedItemRow);
            CaveExplorer.getPlayerCharacter().getInventory().putItemInSlot(targetedItem, selectedItemCol, selectedItemRow);
        }
        haltAnimation();
    }


    // Drag Animation
    private static ImageView animationImageView = new ImageView();

    private static void launchAnimation(ImageView imageViewToImitate){

        animationImageView.setViewport(imageViewToImitate.getViewport());
        animationImageView.setImage(imageViewToImitate.getImage());
        animationImageView.setFitWidth(imageViewToImitate.getFitWidth());
        animationImageView.setFitHeight(imageViewToImitate.getFitHeight());
        animationImageView.setOpacity(0.8);

        CaveExplorer.getMainGameScene().getChildren().add(animationImageView);
        dragAnimation.start();
    }

    private static void haltAnimation(){
        CaveExplorer.getMainGameScene().getChildren().remove(animationImageView);
        dragAnimation.stop();
    }


    private static AnimationTimer dragAnimation = new AnimationTimer() {
        double x;
        double y;
        @Override
        public void handle(long now) {
            x = (MouseInputHandler.xMousePosition + CaveExplorer.getMainGameScene().getWidth()/2)/StageResizeListener.getCurrentScaleX();
            y = (MouseInputHandler.yMousePosition + CaveExplorer.getMainGameScene().getHeight()/2)/StageResizeListener.getCurrentScaleY();
            animationImageView.relocate(x,y);
        }
    };





    private InventoryDragAndDropHandler(){

    }
}
