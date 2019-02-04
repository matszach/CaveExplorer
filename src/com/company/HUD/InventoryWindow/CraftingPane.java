package com.company.HUD.InventoryWindow;

import com.company.GameValues;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;

public class CraftingPane extends Pane {

    public CraftingPane(){
        setPrefSize(250,200);
        relocate(10,10);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10), null)));
    }
}
