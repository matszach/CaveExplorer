package com.company.HUD.DragAndDropHandler;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.CaveExplorer;
import com.company.Items.Item;
import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.awt.*;

import static javafx.scene.paint.Color.BLUE;


public class InventoryDragAndDropHandler {

    // instance
    private static InventoryDragAndDropHandler i = new InventoryDragAndDropHandler();

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
        if(CaveExplorer.getPlayerCharacter().getInventory().getItemsInInventory()[col][row] != null){
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
        @Override
        public void handle(long now) {
            double xDirection = MouseInfo.getPointerInfo().getLocation().getX() - CaveExplorer.getMainGameScene().getWidth()/2 - 170;
            double yDirection = MouseInfo.getPointerInfo().getLocation().getY() - CaveExplorer.getMainGameScene().getHeight()/2 + 210;
            animationImageView.relocate(xDirection,yDirection);
        }
    };





    private InventoryDragAndDropHandler(){

    }
}
