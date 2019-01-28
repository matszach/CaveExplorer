package com.company.HUD;

import com.company.Items.Item;

public class InventoryItemDragHandler {

    // instance
    private static InventoryItemDragHandler i = new InventoryItemDragHandler();

    // item pointed at
    private static int refItemRow;
    public static int getRefItemRow() {
        return refItemRow;
    }
    public static void setRefItemRow(int refItemRow) {
        InventoryItemDragHandler.refItemRow = refItemRow;
    }

    private static int refItemCol;
    public static int getRefItemCol() {
        return refItemCol;
    }
    public static void setRefItemCol(int refItemCol) {
        InventoryItemDragHandler.refItemCol = refItemCol;
    }




    //





    private InventoryItemDragHandler(){

    }
}
