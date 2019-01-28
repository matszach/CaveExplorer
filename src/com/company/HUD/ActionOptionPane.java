package com.company.HUD;

import com.company.GameValues;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ActionOptionPane extends StackPane {

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

    public ActionOptionPane(){
        setPrefSize(40,40);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_OVERLAY_BLUE, new CornerRadii(10), new Insets(5,5,5,5))));
    }
}
