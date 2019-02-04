package com.company.HUD.InventoryWindow;

import com.company.GameValues;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;

public class BackpackPane extends Pane {

    private ItemPane[][] itemPanes = new ItemPane[10][5];
    public ItemPane[][] getItemPanes() {
        return itemPanes;
    }

    private void placeItemPane(Node node, int xRow, int yRow){
        node.relocate(xRow*40, yRow*40);
        getChildren().add(node);
    }

    public BackpackPane(){
        getChildren().clear(); // <- !!! this allows the game to switch from menu to game-view
        setPrefSize(400,200);
        relocate(10,220);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10), null)));

        //TODO
        for(int x = 0; x <itemPanes.length; x++){
            for(int y = 0; y <itemPanes[0].length; y++){
                itemPanes[x][y] = new ItemPane(x,y);
                placeItemPane(itemPanes[x][y], x, y);
            }
        }
    }
}
