package com.company.HUD.DragAndDropHandler;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.CaveExplorer;
import com.company.Items.Item;

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
    public static void readySelectedItem(int row, int col){
        selectedItemRow = row;
        selectedItemCol = col;
        selectedItemPresent = true;
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
    }




    private InventoryDragAndDropHandler(){

    }
}
