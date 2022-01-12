package ch.bbcag.carsracergame;

import ch.bbcag.carsracergame.common.scene.SceneType;
import ch.bbcag.carsracergame.scenes.EndScene;
import ch.bbcag.carsracergame.scenes.GameScene;
import ch.bbcag.carsracergame.scenes.HelpScene;
import ch.bbcag.carsracergame.scenes.StartScene;
import ch.bbcag.carsracergame.common.scene.Navigator;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class App extends Application {
    GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigator navigator = new Navigator(primaryStage);
        navigator.registerScene(SceneType.START, () -> new StartScene(navigator));
        navigator.registerScene(SceneType.GAME, () -> new GameScene(navigator));
        navigator.registerScene(SceneType.END, () -> new EndScene(navigator));
        navigator.registerScene(SceneType.HELP, () -> new HelpScene(navigator));
        navigator.navigateTo(SceneType.START);

        primaryStage.setTitle("ch/bbcag/carsracergame");
        primaryStage.show();
    }
}
