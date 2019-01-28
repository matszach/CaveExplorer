package com.company.HUD;


import com.company.CaveExplorer;
import com.company.GameValues;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.text.DecimalFormat;

public class CoordinateDisplay extends VBox {

    private Text xTF = new Text();
    private Text yTF = new Text();

    private DecimalFormat decForm = new DecimalFormat("0.00");

    AnimationTimer coordinateUpdater = new AnimationTimer() {
        @Override
        public void handle(long now) {
            xTF.setText("X : " + decForm.format(CaveExplorer.getPlayerCharacter().getTileX()));
            yTF.setText("Y : " + decForm.format(CaveExplorer.getPlayerCharacter().getTileY()));
        }
    };

    public CoordinateDisplay(){
        relocate(20,20);
        setPrefSize(70,50);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10), null)));
        setSpacing(10);
        setAlignment(Pos.CENTER);
        getChildren().addAll(xTF,yTF);
        coordinateUpdater.start();

    }
}
