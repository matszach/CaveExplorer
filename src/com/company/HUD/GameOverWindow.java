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

public class GameOverWindow extends VBox {

    // Style
    private final String BTN_STYLE = "-fx-font: 26 arial;";

    // Nodes
    private Text gameOverLabel = new Text("GAME OVER");
    private CE_Button menuButton = new CE_Button("MENU");
    private CE_Button quitButton = new CE_Button("QUIT");


    private void buildMenu(){
        gameOverLabel.setStyle(BTN_STYLE);
        gameOverLabel.setTranslateY(-10);
        getChildren().addAll(gameOverLabel, menuButton, quitButton);
    }


    public GameOverWindow(){
        relocate(180,170);
        setPrefSize(240,210);
        setSpacing(10);
        setAlignment(Pos.CENTER);
        buildMenu();
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10),null)));


        // on actions
        quitButton.setOnAction(e->{
            CaveExplorer.closeGame();
        });
        menuButton.setOnAction(e->{
            CaveExplorer.closeGameOverWindow();
            KeyInputHandler.reset();
            CaveExplorer.showStartMenu();
        });


    }
}
