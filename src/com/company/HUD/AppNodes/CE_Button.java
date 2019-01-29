package com.company.HUD.AppNodes;

import com.company.GameValues;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

public class CE_Button extends Button {

    // Size
    private final int WIDTH = 200;
    private final int HEIGHT = 50;

    // Corner Radii
    private final CornerRadii CR = new CornerRadii(10);

    // Style
    private final String CE_BUTTON_STYLE = "-fx-font: 26 arial;";

    // Mouse entered / exited effect
    private void setHoverEffect(){
        setOnMouseEntered(e->{
            setBackground(new Background(new BackgroundFill(GameValues.GUI_FLASH_BLUE, new CornerRadii(10), null)));
            setScaleX(1.05);
            setScaleY(1.05);
        });
        setOnMouseExited(e->{
            setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
            setScaleX(1.0);
            setScaleY(1.0);
        });
    }


    public CE_Button(){
        setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, CR, null)));
        setPrefSize(WIDTH,HEIGHT);
        setStyle(CE_BUTTON_STYLE);
        setHoverEffect();
    }

    public CE_Button(String text){
        super(text);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, CR, null)));
        setPrefSize(WIDTH,HEIGHT);
        setStyle(CE_BUTTON_STYLE);
        setHoverEffect();
    }
}
