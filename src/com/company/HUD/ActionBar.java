package com.company.HUD;

import com.company.GameValues;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;

public class ActionBar extends HBox {

    private static ActionBarItemPane[] actionOptionPanes = new ActionBarItemPane[10];

    private static ActionBarItemPane[] buildActonPanes() {
        for (int i = 0; i < actionOptionPanes.length; i++) {
            actionOptionPanes[i] = new ActionBarItemPane(i, 5);
        }
        return actionOptionPanes;
    }


    private static int selectedPaneNum;
    public static int getSelectedPaneNum() {
        return selectedPaneNum;
    }

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





    public ActionBar(){
        relocate(115,550);
        setPrefSize(380,40);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10),null)));
        getChildren().addAll(buildActonPanes());
        actionOptionPanes[0].select();
        selectedPaneNum = 0;
    }
}
