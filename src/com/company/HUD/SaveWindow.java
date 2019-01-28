package com.company.HUD;

import com.company.CaveExplorer;
import com.company.GameStates_GameSavingAndLoading.GameSaverAndLoader;
import com.company.GameValues;
import com.company.PngMapGenerator;
import com.company.Scenes.MainGameScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;

public class SaveWindow  extends VBox {

    // Style
    private final String BTN_STYLE = "-fx-font: 26 arial;";

    // Nodes
    private static Text saveLabel = new Text("SAVE GAME");
    private static Button[] gameSaveButtons = new Button[4];
    private static Button returnButton = new Button("RETURN");


    public static void updateSaveFileButtons(){
        for(int i = 0; i < gameSaveButtons.length; i++){

            File saveFile = new File("GameStates\\gameState" + (i+1) + ".save");

            if(saveFile.exists()){
                gameSaveButtons[i].setText("Save "+(i+1));
                int saveNum = i + 1;
            } else {
                gameSaveButtons[i].setText("- empty -");
            }

            int saveNum = i+1;
            gameSaveButtons[i].setOnAction(e->{
                GameSaverAndLoader.saveToFile(CaveExplorer.getCurrentGameState(), saveNum);
                CaveExplorer.closeSaveWindow();

                // TODO temp
                PngMapGenerator.drawMap(MainGameScene.getBoard().getBoardTileTypes());
            });

        }
    }




    // style methods
    private void buildButtons(){

        for(int i = 0; i < gameSaveButtons.length; i++){
            gameSaveButtons[i] = new Button();
            gameSaveButtons[i].setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
            gameSaveButtons[i].setPrefSize(200,50);
            gameSaveButtons[i].setStyle(BTN_STYLE);
        }

        returnButton.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        returnButton.setPrefSize(200,50);
        returnButton.setStyle(BTN_STYLE);

        setButtonHoverEffect(gameSaveButtons);
        setButtonHoverEffect(returnButton);

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

    public SaveWindow(){

        relocate(180,170);
        setPrefSize(240,360);
        setSpacing(10);
        setAlignment(Pos.CENTER);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10),null)));

        buildButtons();
        updateSaveFileButtons();
        saveLabel.setStyle(BTN_STYLE);

        getChildren().add(saveLabel);
        getChildren().addAll(gameSaveButtons);
        getChildren().add(returnButton);

        returnButton.setOnAction(e->{
            CaveExplorer.closeSaveWindow();
        });



    }
}
