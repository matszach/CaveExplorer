package com.company;

import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public final class StageResizeListener {

    private static double currentScaleX = 1;
    public static double getCurrentScaleX() {
        return currentScaleX;
    }

    private static double currentScaleY = 1;
    public static double getCurrentScaleY() {
        return currentScaleY;
    }

    public StageResizeListener(Stage primaryStage) {

        // TODO replace consecutive adding of a new Scale instance on top of the existing ones with modifying a current scale

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            currentScaleX *= newVal.doubleValue()/oldVal.doubleValue();
            Scale scale = new Scale(newVal.doubleValue()/oldVal.doubleValue(),1);
            CaveExplorer.getMainGameScene().getTransforms().add(scale);
            System.out.println(currentScaleX + " / " + currentScaleY);
        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            currentScaleY *= newVal.doubleValue()/oldVal.doubleValue();
            Scale scale = new Scale(1,newVal.doubleValue()/oldVal.doubleValue());
            CaveExplorer.getMainGameScene().getTransforms().add(scale);
            System.out.println(currentScaleX + " / " + currentScaleY);
        });

    }
}
