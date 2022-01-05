package CarsRacerGame;

import CarsRacerGame.Enums.SceneType;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Navigator {
    private Stage stage;
    private Map<SceneType, Scene> sceneMap = new HashMap<>();

    public Navigator(Stage stage) {
        this.stage = stage;
    }

    public void registerScene(SceneType sceneType, Scene scene) {
        sceneMap.put(sceneType, scene);
    }

    public void navigateTo(SceneType sceneType) {
        stage.setScene(sceneMap.get(sceneType));
        stage.show();
    }
}