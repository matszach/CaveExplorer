package com.company.Scenes;

import com.company.CaveExplorer;
import com.company.GameStates_GameSavingAndLoading.GameSaverAndLoader;
import com.company.GameValues;
import com.company.ImageBank;
import com.company.KeyInputHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
        logo.setTranslateY(-GameValues.getWindowSideLength()/20*8);

    }


    // Initial menu
    private static VBox initialMenu = new VBox(10);
    private static Button newGameButton = new Button("NEW GAME");
    private static Button loadGameButton = new Button("LOAD GAME");
    private static Button optionsButton = new Button("OPTIONS");
    private static Button aboutButton = new Button("ABOUT");

    private static void buildInitialMenu(){
        initialMenu.setMaxSize(250,280);
        initialMenu.setMinSize(250,280);
        initialMenu.setBackground(new Background(new BackgroundFill(GameValues.GUI_OVERLAY_BLUE, new CornerRadii(20), null)));
        initialMenu.setAlignment(Pos.CENTER);
        initialMenu.getChildren().addAll(newGameButton, loadGameButton, optionsButton, aboutButton);
        initialMenu.setTranslateY(GameValues.getWindowSideLength()/20);

        newGameButton.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        newGameButton.setPrefSize(200,50);
        newGameButton.setStyle(BTN_STYLE);

        loadGameButton.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        loadGameButton.setPrefSize(200,50);
        loadGameButton.setStyle(BTN_STYLE);

        optionsButton.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        optionsButton.setPrefSize(200,50);
        optionsButton.setStyle(BTN_STYLE);

        aboutButton.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        aboutButton.setPrefSize(200,50);
        aboutButton.setStyle(BTN_STYLE);
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
    private static Button startGameButton = new Button("START");
    private static Button returnButton = new Button("RETURN");

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

        startGameButton.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        startGameButton.setPrefSize(200,50);
        startGameButton.setStyle(BTN_STYLE);

        returnButton.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        returnButton.setPrefSize(200,50);
        returnButton.setStyle(BTN_STYLE);

    }


    // Load Game Menu
    private static VBox loadGameMenu = new VBox(10);
    private static Text loadGameTitle = new Text("LOAD GAME");
    private static Button[] gameStateButtons = new Button[4];
    private static Button returnButton_2 = new Button("RETURN");


    private static void buildLoadGameMenu(){

        loadGameMenu.setMaxSize(250,360);
        loadGameMenu.setMinSize(250,360);
        loadGameMenu.setBackground(new Background(new BackgroundFill(GameValues.GUI_OVERLAY_BLUE, new CornerRadii(20), null)));
        loadGameMenu.setAlignment(Pos.CENTER);
        loadGameMenu.setTranslateY(GameValues.getWindowSideLength()/20*2);

        loadGameTitle.setStyle(BTN_STYLE);

        for(int i = 0; i < gameStateButtons.length; i++){
            gameStateButtons[i] = new Button();
            gameStateButtons[i].setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
            gameStateButtons[i].setPrefSize(200,50);
            gameStateButtons[i].setStyle(BTN_STYLE);
        }

        returnButton_2.setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), null)));
        returnButton_2.setPrefSize(200,50);
        returnButton_2.setStyle(BTN_STYLE);

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


    // style methods
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

        setButtonHoverEffect(newGameButton, loadGameButton, optionsButton, aboutButton, returnButton, startGameButton, returnButton_2);
        setButtonHoverEffect(gameStateButtons);

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
