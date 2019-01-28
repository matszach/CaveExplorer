package com.company;

import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public final class StageResizeListener {

    public StageResizeListener(Stage primaryStage) {

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            Scale scale = new Scale(newVal.doubleValue()/oldVal.doubleValue(),1);
            CaveExplorer.getMainGameScene().getTransforms().add(scale);

        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            Scale scale = new Scale(1,newVal.doubleValue()/oldVal.doubleValue());
            CaveExplorer.getMainGameScene().getTransforms().add(scale);
        });

    }
}
