package ch.bbcag.carsracergame;

import ch.bbcag.carsracergame.common.Cars;
import ch.bbcag.carsracergame.common.scene.SceneType;
import ch.bbcag.carsracergame.scenes.*;
import ch.bbcag.carsracergame.common.scene.Navigator;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class App extends Application {
    GraphicsContext gc;

    Cars cars = new Cars();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigator navigator = new Navigator(primaryStage);
        navigator.registerScene(SceneType.START, () -> new StartScene(navigator));
        navigator.registerScene(SceneType.GAME, () -> new GameScene(navigator, cars));
        navigator.registerScene(SceneType.END, () -> new EndScene(navigator));
        navigator.registerScene(SceneType.HELP, () -> new HelpScene(navigator));
        navigator.registerScene(SceneType.CHARACTER, () -> new CharacterScene(navigator, cars));
        navigator.navigateTo(SceneType.START);

        primaryStage.setTitle("ch/bbcag/carsracergame");
        primaryStage.show();
    }
}
