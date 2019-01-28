package com.company.HUD;

import com.company.GameValues;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;

public class ActionChoiceBox extends HBox {

    private static ActionOptionPane[] actionOptionPanes = new ActionOptionPane[8];

    private static ActionOptionPane[] buildActonPanes() {
        for (int i = 0; i < actionOptionPanes.length; i++) {
            actionOptionPanes[i] = new ActionOptionPane();
        }
        return actionOptionPanes;
    }


    private static int selectedPaneNum;
    public static void moveSelectionUp(){
        actionOptionPanes[selectedPaneNum].unSelect();
        if(selectedPaneNum >= actionOptionPanes.length-1){
            selectedPaneNum = 0;
        } else {
            selectedPaneNum++;
        }
        actionOptionPanes[selectedPaneNum].select();
    }
    public static void moveSelectionDown(){
        actionOptionPanes[selectedPaneNum].unSelect();
        if(selectedPaneNum <= 0){
            selectedPaneNum = actionOptionPanes.length-1;
        } else {
            selectedPaneNum--;
        }
        actionOptionPanes[selectedPaneNum].select();
    }





    public ActionChoiceBox(){
        relocate(145,550);
        setPrefSize(320,40);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10),null)));
        getChildren().addAll(buildActonPanes());
        actionOptionPanes[0].select();
        selectedPaneNum = 0;
    }
}
