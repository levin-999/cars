package CarsRacerGame.common;

import CarsRacerGame.common.enums.SceneType;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Navigator {
    private Stage stage;
    private Map<SceneType, BaseScene> sceneMap = new HashMap<>();
    private BaseScene currentScene;

    public Navigator(Stage stage) {
        this.stage = stage;
    }

    public void registerScene(SceneType sceneType, BaseScene scene) {
        sceneMap.put(sceneType, scene);
    }

    public void navigateTo(SceneType sceneType) {
        if (currentScene != null) {
            currentScene.onExit();
        }
        currentScene = sceneMap.get(sceneType);
        stage.setScene(currentScene);
        currentScene.onEnter();
        stage.show();
    }
}