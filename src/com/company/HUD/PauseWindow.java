package com.company.HUD;

import com.company.CaveExplorer;
import com.company.GameStates_GameSavingAndLoading.GameSaverAndLoader;
import com.company.GameValues;
import com.company.KeyInputHandler;
import com.company.PngMapGenerator;
import com.company.Scenes.MainGameScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
    private Button returnButton = new Button("RETURN");
    private Button saveButton = new Button("SAVE");
    private Button menuButton = new Button("MENU");
    private Button quitButton = new Button("QUIT");


    private void buildMenu(){

        pauseLabel.setStyle(BTN_STYLE);
        pauseLabel.setTranslateY(-10);

        returnButton.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        returnButton.setPrefSize(200,50);
        returnButton.setStyle(BTN_STYLE);

        saveButton.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        saveButton.setPrefSize(200,50);
        saveButton.setStyle(BTN_STYLE);

        menuButton.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        menuButton.setPrefSize(200,50);
        menuButton.setStyle(BTN_STYLE);

        quitButton.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        quitButton.setPrefSize(200,50);
        quitButton.setStyle(BTN_STYLE);

        getChildren().addAll(pauseLabel, returnButton, saveButton, menuButton, quitButton);

    }


    private void setButtonHoverEffect(Button...buttons){
        for(Button b : buttons){
            b.setOnMouseEntered(e->{
                b.setBackground(new Background(new BackgroundFill(GameValues.GUI_FLASH_BLUE, new CornerRadii(10), null)));
                b.setScaleX(1.05);
                b.setScaleY(1.05);
            });
            b.setOnMouseExited(e->{
                b.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
                b.setScaleX(1.0);
                b.setScaleY(1.0);
            });
        }
    }

    public PauseWindow(){
        relocate(180,170);
        setPrefSize(240,330);
        setSpacing(10);
        setAlignment(Pos.CENTER);
        buildMenu();
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10),null)));

        setButtonHoverEffect(quitButton, saveButton, menuButton, returnButton);

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
