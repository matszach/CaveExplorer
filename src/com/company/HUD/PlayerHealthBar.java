package com.company.HUD;

import com.company.Agent.Agent;
import com.company.CaveExplorer;
import com.company.GameValues;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class PlayerHealthBar extends StackPane {

    private final int HEIGHT = 20;
    private final int WIDTH = 380;

    // base constant bar
    private static final double MAX_HEALTHBAR_WIDTH = 375;
    private static final double MAX_HEALTHBAR_HEIGHT = 15;
    private StackPane baseHealthBar = new StackPane();

    // front dynamic bar
    private Pane frontHealthBar = new Pane();

    // dynamic text
    private Text healthText = new Text();
    private double displayedHealthNumber = 0;


    // health bar resizer
    private final double MIN_DIFFERENCE_TO_UPDATE_BAR = 0.001;
    private AnimationTimer healthBarResizer = new AnimationTimer() {
        @Override
        public void handle(long now) {

            // this prevents the bar from oin back and forth rapidly when only a minor difference between
            // display and actual player heath is the case
            if((Math.abs(frontHealthBar.getWidth()/baseHealthBar.getWidth() -
                CaveExplorer.getPlayerCharacter().getCurrentHealth()/Agent.MAX_HEALTH) < MIN_DIFFERENCE_TO_UPDATE_BAR)){
                return;
            }

            if(frontHealthBar.getWidth()/baseHealthBar.getWidth() < CaveExplorer.getPlayerCharacter().getCurrentHealth()/Agent.MAX_HEALTH){
                frontHealthBar.setMaxWidth(frontHealthBar.getMaxWidth() + 1);
                displayedHealthNumber += Agent.MAX_HEALTH/MAX_HEALTHBAR_WIDTH;
            } else if (frontHealthBar.getWidth()/baseHealthBar.getWidth() > CaveExplorer.getPlayerCharacter().getCurrentHealth()/Agent.MAX_HEALTH) {
                frontHealthBar.setMaxWidth(frontHealthBar.getMaxWidth() - 1);
                displayedHealthNumber -= Agent.MAX_HEALTH/MAX_HEALTHBAR_WIDTH;
            }

            healthText.setText(Math.round(displayedHealthNumber) + " / " + (int)Agent.MAX_HEALTH);
        }
    };



    public PlayerHealthBar(){

        relocate(115,528);
        setPrefSize(WIDTH,HEIGHT);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10),null)));

        setAlignment(Pos.CENTER);

        // base health bar
        baseHealthBar.setMaxSize(MAX_HEALTHBAR_WIDTH, MAX_HEALTHBAR_HEIGHT);
        baseHealthBar.setBackground(new Background(new BackgroundFill(GameValues.HP_BAR_BASE, new CornerRadii(10), null)));
        getChildren().add(baseHealthBar);

        baseHealthBar.setAlignment(Pos.BASELINE_LEFT);

        // front health bar
        frontHealthBar.setMaxSize(0, MAX_HEALTHBAR_HEIGHT);
        frontHealthBar.setBackground(new Background(new BackgroundFill(GameValues.HP_BAR_FRONT, new CornerRadii(10), null)));
        baseHealthBar.getChildren().add(frontHealthBar);

        healthBarResizer.start();

        // health text
        healthText.setStyle("-fx-font: 17 arial;");
        getChildren().add(healthText);


    }
}
