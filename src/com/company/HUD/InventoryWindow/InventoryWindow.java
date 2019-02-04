package com.company.HUD.InventoryWindow;

import com.company.CaveExplorer;
import com.company.GameValues;

import com.company.HUD.ActionBar;
import com.company.ImageBank;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class InventoryWindow extends Pane {

    // CRAFT PANE
    private CraftingPane craftingPane = new CraftingPane();

    // BACK PACK PANE
    private BackpackPane backpackPane = new BackpackPane();

    // RESOURCE PANE
    private ResourcePane resourcePane = new ResourcePane();

    // initiates the inventory window
    public void initiate(){
        getChildren().clear(); // <- !!! this allows the game to switch from menu to game-view
        getChildren().addAll(craftingPane,resourcePane,backpackPane);
    }


    // updates imageView (for when item is removed / used)
    public void updateItemPane(int col, int row){
        if(row <= 4){
            backpackPane.getItemPanes()[col][row].buildItemView();
        } else {
            ActionBar.getActionOptionPanes()[col].buildItemView();
        }

    }

    public InventoryWindow(){
        relocate(95,90);
        setPrefSize(420,430);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10),null)));

    }
}
