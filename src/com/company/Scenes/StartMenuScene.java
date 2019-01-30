package com.company.Scenes;

import com.company.CaveExplorer;
import com.company.GameStates_GameSavingAndLoading.GameSaverAndLoader;
import com.company.GameValues;
import com.company.HUD.AppNodes.CE_Button;
import com.company.ImageBank;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.File;

public class StartMenuScene extends StackPane {

    // Style
    private static final String BTN_STYLE = "-fx-font: 26 arial;";
    private static final String LBL_STYLE = "-fx-font: 14 arial;";


    // Background
    private static ImageView background = new ImageView(ImageBank.getMenuBackground());

    private static void buildBackground(){
        background.setFitWidth(GameValues.getWindowSideLength());
        background.setFitHeight(GameValues.getWindowSideLength());
    }

    // Logo
    private static ImageView logo = new ImageView(ImageBank.getLogo());

    private static void  buildLogo(){
        logo.setFitHeight(60);
        logo.setPreserveRatio(true);
        logo.setTranslateY(-GameValues.getWindowSideLength()/20*7);
        logo.setEffect(new DropShadow(50,0,0, GameValues.GUI_MAIN_BLUE));

    }

    private AnimationTimer logoAnimation = new AnimationTimer() {

        private int rotateTimer = 0;
        private int scaleTimer = 0;

        @Override
        public void handle(long now) {

            // rotation
            if(rotateTimer < 100){
                logo.setRotate(rotateTimer*0.02);
            } else if(rotateTimer < 300){
                logo.setRotate((200 - rotateTimer)*0.02);
            } else {
                logo.setRotate((-400 + rotateTimer)*0.02);
            }

            rotateTimer++;

            if(rotateTimer >= 400){
                rotateTimer = 0;
            }

            // x-scaling

            if(scaleTimer < 70){
                logo.setScaleX(1 + scaleTimer*0.001);
            } else if(scaleTimer < 210){
                logo.setScaleX(1.14 - scaleTimer*0.001);
            } else {
                logo.setScaleX(0.72 + scaleTimer*0.001);
            }

            scaleTimer++;

            if(scaleTimer >= 280){
                scaleTimer = 0;
            }
        }
    };
    public void launchAnimation(){
        logoAnimation.start();
    }
    public void freezeAnimation(){
        logoAnimation.stop();
    }


    // Initial menu
    private static VBox initialMenu = new VBox(10);
    private static CE_Button newGameButton = new CE_Button("NEW GAME");
    private static CE_Button loadGameButton = new CE_Button("LOAD GAME");
    private static CE_Button optionsButton = new CE_Button("OPTIONS");
    private static CE_Button aboutButton = new CE_Button("ABOUT");

    private static void buildInitialMenu(){
        initialMenu.setMaxSize(250,280);
        initialMenu.setMinSize(250,280);
        initialMenu.setBackground(new Background(new BackgroundFill(GameValues.GUI_OVERLAY_BLUE, new CornerRadii(20), null)));
        initialMenu.setAlignment(Pos.CENTER);
        initialMenu.getChildren().addAll(newGameButton, loadGameButton, optionsButton, aboutButton);
        initialMenu.setTranslateY(GameValues.getWindowSideLength()/20);
    }


    // New Game Option Menu
    private static VBox newGameOptionMenu = new VBox(5);
    private static Text newGameTitle = new Text("NEW GAME OPTIONS");
    private static Text mapSizeLabel = new Text("Map size");
    private static Slider mapSizeSlider = new Slider(1000, 10000, 100);
    private static Text resourceLabel = new Text("Resource quantity");
    private static Slider resourceAmountSlider = new Slider(0,100,10);
    private static Text terrainLabel = new Text("Terrain features quantity");
    private static Slider terrainAmountSlider = new Slider(0,100,10);
    private static Text genStructuresLabel = new Text("Generated structures quantity");
    private static Slider generatedStructuresAmountSlider = new Slider(0,100,10);
    private static CE_Button startGameButton = new CE_Button("START");
    private static CE_Button returnButton = new CE_Button("RETURN");

    private static void buildNewGameOptionsMenu(){
        newGameOptionMenu.setMaxSize(400,420);
        newGameOptionMenu.setMinSize(400,420);
        newGameOptionMenu.setBackground(new Background(new BackgroundFill(GameValues.GUI_OVERLAY_BLUE, new CornerRadii(20), null)));
        newGameOptionMenu.setAlignment(Pos.CENTER);
        newGameOptionMenu.getChildren().addAll(
                newGameTitle,
                mapSizeLabel,
                mapSizeSlider,
                resourceLabel,
                resourceAmountSlider,
                terrainLabel,
                terrainAmountSlider,
                genStructuresLabel,
                generatedStructuresAmountSlider,
                startGameButton,
                returnButton);
        newGameOptionMenu.setTranslateY(GameValues.getWindowSideLength()/20*2);


        newGameTitle.setStyle(BTN_STYLE);

        mapSizeLabel.setStyle(LBL_STYLE);

        mapSizeSlider.adjustValue(5500);
        mapSizeSlider.setMaxWidth(380);
        mapSizeSlider.setMajorTickUnit(1000);
        mapSizeSlider.setShowTickMarks(true);
        mapSizeSlider.setShowTickLabels(true);
        mapSizeSlider.setSnapToTicks(true);

        resourceLabel.setStyle(LBL_STYLE);

        resourceAmountSlider.adjustValue(50);
        resourceAmountSlider.setMaxWidth(380);
        resourceAmountSlider.setMajorTickUnit(10);
        resourceAmountSlider.setShowTickMarks(true);
        resourceAmountSlider.setShowTickLabels(true);
        resourceAmountSlider.setSnapToTicks(true);

        terrainLabel.setStyle(LBL_STYLE);

        terrainAmountSlider.adjustValue(50);
        terrainAmountSlider.setMaxWidth(380);
        terrainAmountSlider.setMajorTickUnit(10);
        terrainAmountSlider.setShowTickMarks(true);
        terrainAmountSlider.setShowTickLabels(true);
        terrainAmountSlider.setSnapToTicks(true);

        genStructuresLabel.setStyle(LBL_STYLE);

        generatedStructuresAmountSlider.adjustValue(50);
        generatedStructuresAmountSlider.setMaxWidth(380);
        generatedStructuresAmountSlider.setMajorTickUnit(10);
        generatedStructuresAmountSlider.setShowTickMarks(true);
        generatedStructuresAmountSlider.setShowTickLabels(true);
        generatedStructuresAmountSlider.setSnapToTicks(true);

    }


    // Load Game Menu
    private static VBox loadGameMenu = new VBox(10);
    private static Text loadGameTitle = new Text("LOAD GAME");
    private static CE_Button[] gameStateButtons = new CE_Button[4];
    private static CE_Button returnButton_2 = new CE_Button("RETURN");


    private static void buildLoadGameMenu(){

        loadGameMenu.setMaxSize(250,360);
        loadGameMenu.setMinSize(250,360);
        loadGameMenu.setBackground(new Background(new BackgroundFill(GameValues.GUI_OVERLAY_BLUE, new CornerRadii(20), null)));
        loadGameMenu.setAlignment(Pos.CENTER);
        loadGameMenu.setTranslateY(GameValues.getWindowSideLength()/20*2);

        loadGameTitle.setStyle(BTN_STYLE);

        for(int i = 0; i < gameStateButtons.length; i++){
            gameStateButtons[i] = new CE_Button();
        }

        loadGameMenu.getChildren().add(loadGameTitle);
        loadGameMenu.getChildren().addAll(gameStateButtons);
        loadGameMenu.getChildren().add(returnButton_2);

    }
    private static void updateSaveFileButtons(){
        for(int i = 0; i < gameStateButtons.length; i++){
            File saveFile = new File("GameStates\\gameState" + (i+1) + ".save");

            if(saveFile.exists()){
                // if file found -> setOnAction to load the game from it
                gameStateButtons[i].setText("Save "+(i+1));
                int saveNum = i + 1;
                gameStateButtons[i].setOnAction(e->{
                    CaveExplorer.loadGame(GameSaverAndLoader.loadFromFile(saveNum));
                    CaveExplorer.showGame();
                });
            } else {
                gameStateButtons[i].setText("- empty -");
                // clears if save deleted
                gameStateButtons[i].setOnAction(null);
            }
        }
    }

    // switching methods
    private void goToNewGameOptions(){
        if(getChildren().contains(initialMenu)){
            getChildren().remove(initialMenu);
        }
        getChildren().add(newGameOptionMenu);
    }
    private void goToLoadGameMenu(){
        if(getChildren().contains(initialMenu)){
            getChildren().remove(initialMenu);
        }
        updateSaveFileButtons();
        getChildren().add(loadGameMenu);
    }
    public void goBackToMainMenu(){
        if(getChildren().contains(newGameOptionMenu)){
            getChildren().remove(newGameOptionMenu);
        }
        if(getChildren().contains(loadGameMenu)){
            getChildren().remove(loadGameMenu);
        }
        getChildren().add(initialMenu);
    }


    public StartMenuScene(){

        buildBackground();
        buildLogo();
        buildInitialMenu();
        buildNewGameOptionsMenu();
        buildLoadGameMenu();

        getChildren().addAll(background,logo,initialMenu);

        // on actions, main menu
        newGameButton.setOnAction(e->{
            goToNewGameOptions();
        });
        loadGameButton.setOnAction(e->{
            goToLoadGameMenu();
        });

        // on actions, new game menu
        returnButton.setOnAction(e->{
            goBackToMainMenu();
        });
        startGameButton.setOnAction(e->{
            CaveExplorer.startNewGame((int)mapSizeSlider.getValue(), resourceAmountSlider.getValue(), terrainAmountSlider.getValue(), generatedStructuresAmountSlider.getValue());
            CaveExplorer.showGame();
        });

        // on actions, load game menu
        // save buttons -> in their update method
        returnButton_2.setOnAction(e->{
            goBackToMainMenu();
        });

    }
}
