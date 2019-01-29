package com.company.HUD;

import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.HUD.AppNodes.CE_Button;
import com.company.KeyInputHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PauseWindow extends VBox {

    // Style
    private final String BTN_STYLE = "-fx-font: 26 arial;";

    // Nodes
    private Text pauseLabel = new Text("PAUSED");
    private CE_Button returnButton = new CE_Button("RETURN");
    private CE_Button saveButton = new CE_Button("SAVE");
    private CE_Button menuButton = new CE_Button("MENU");
    private CE_Button quitButton = new CE_Button("QUIT");


    private void buildMenu(){
        pauseLabel.setStyle(BTN_STYLE);
        pauseLabel.setTranslateY(-10);
        getChildren().addAll(pauseLabel, returnButton, saveButton, menuButton, quitButton);
    }


    public PauseWindow(){
        relocate(180,170);
        setPrefSize(240,330);
        setSpacing(10);
        setAlignment(Pos.CENTER);
        buildMenu();
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10),null)));


        // on actions
        quitButton.setOnAction(e->{
            CaveExplorer.closeGame();
        });
        saveButton.setOnAction(e->{
            CaveExplorer.openSaveWindow();
        });
        menuButton.setOnAction(e->{
            CaveExplorer.closePauseWindow();
            KeyInputHandler.reset();
            CaveExplorer.showStartMenu();
        });
        returnButton.setOnAction(e->{
            CaveExplorer.closePauseWindow();
            KeyInputHandler.reset();
        });



    }

}
