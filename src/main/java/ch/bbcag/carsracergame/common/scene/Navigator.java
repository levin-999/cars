package ch.bbcag.carsracergame.common.scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Navigator {
    private Map<SceneType, Supplier<BaseScene>> scenesToConstructor = new HashMap<>();
    private BaseScene currentScene;
    private Stage stage;

    public Navigator(Stage stage) {
        this.stage = stage;
    }

    public void registerScene(SceneType sceneType, Supplier<BaseScene> f) {
        scenesToConstructor.put(sceneType, f);
    }

    public void navigateTo(SceneType sceneType) {
        if (currentScene != null) {
            currentScene.onExit();
        }

        Supplier<BaseScene> f = scenesToConstructor.get(sceneType);

        if (f != null) {
            BaseScene newScene = f.get();
            currentScene = newScene;
            newScene.onEnter();
            stage.setScene(newScene);
        }
    }
}