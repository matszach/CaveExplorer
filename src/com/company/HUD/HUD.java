package com.company.HUD;

import javafx.scene.layout.*;


public class HUD extends Pane {

    private static ActionChoiceBox actionChoicePane = new ActionChoiceBox();
    private static CoordinateDisplay coordinateDisplay = new CoordinateDisplay();

    public HUD(){
        getChildren().addAll(actionChoicePane, coordinateDisplay);
    }

}
