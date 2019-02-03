package com.company.HUD;

import com.company.GameValues;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;

public class PlayerHealthBar extends StackPane {


    public PlayerHealthBar(){
        relocate(115,528);
        setPrefSize(380,20);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10),null)));

    }
}
