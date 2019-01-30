package com.company.HUD;

import javafx.scene.layout.*;


public class HUD extends Pane {

    private static ActionBar actionBar = new ActionBar();
    private static CoordinateDisplay coordinateDisplay = new CoordinateDisplay();

    public HUD(){
        getChildren().addAll(actionBar, coordinateDisplay);
    }

}
