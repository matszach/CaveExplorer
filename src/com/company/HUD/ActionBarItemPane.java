package com.company.HUD;

import com.company.HUD.DragAndDropHandler.InventoryDragAndDropHandler;
import com.company.HUD.InventoryWindow.ItemPane;

public class ActionBarItemPane extends ItemPane {


    public ActionBarItemPane(int col, int row){
        super(col, row);

        // Mouse event handlers "overridden" to remove mouse hover effect
        setOnMouseEntered(e->select());
        setOnMouseExited(e->{
            if(ActionBar.getSelectedPaneNum() != col){
                unSelect();
            }
        });
        setOnMouseDragEntered(e-> {
            select();
            InventoryDragAndDropHandler.readyTargetedItem(row, col);
        });

        setOnMouseDragExited(e-> {
            if(ActionBar.getSelectedPaneNum() != col){
                unSelect();
            }
            InventoryDragAndDropHandler.unreadyTargetedItem();
            buildItemView();
        });
    }
}
