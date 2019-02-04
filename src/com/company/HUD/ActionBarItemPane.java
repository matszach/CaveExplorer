package com.company.HUD;

import com.company.GameValues;
import com.company.HUD.DragAndDropHandler.InventoryDragAndDropHandler;
import com.company.HUD.InventoryWindow.ItemPane;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ActionBarItemPane extends ItemPane {

    public void select(){
        setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), new Insets(5,5,5,5))));
        setScaleX(1.05);
        setScaleX(1.05);
    }

    public void unSelect(){
        setBackground(new Background(new BackgroundFill(GameValues.GUI_OVERLAY_BLUE, new CornerRadii(10), new Insets(5,5,5,5))));
        setScaleX(1.00);
        setScaleX(1.00);
    }

    public ActionBarItemPane(int col, int row){
        super(col, row);

        // Mouse event handlers "overridden" to remove mouse hover effect
        setOnMouseEntered(null);
        setOnMouseExited(null);
        setOnMouseDragEntered(e-> {
            //select();
            InventoryDragAndDropHandler.readyTargetedItem(row, col);
        });

        setOnMouseDragExited(e-> {
            //unSelect();
            InventoryDragAndDropHandler.unreadyTargetedItem();
            buildItemView();
        });
    }
}
