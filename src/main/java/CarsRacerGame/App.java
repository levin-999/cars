package CarsRacerGame;

import CarsRacerGame.Enums.SceneType;
import CarsRacerGame.Views.EndScene;
import CarsRacerGame.Views.GameScene;
import CarsRacerGame.Views.StartScene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class App extends Application {
    GraphicsContext gc;
    private long lastTimeInNanoSec;

    public void update(double deltaInSec) {

    }

    public void paint() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        lastTimeInNanoSec = System.nanoTime();

        Navigator navigator = new Navigator(primaryStage);
        navigator.registerScene(SceneType.START, new StartScene(navigator));
        navigator.registerScene(SceneType.GAME, new GameScene(navigator));
        navigator.registerScene(SceneType.END, new EndScene(navigator));
        navigator.navigateTo(SceneType.START);

        new AnimationTimer() {
            @Override
            public void handle(long currentTimeInNanoSec) {


                long deltaInNanoSec = currentTimeInNanoSec - lastTimeInNanoSec;
                double deltaInSec = deltaInNanoSec / 1000000000d; //oder: 1e9;

                lastTimeInNanoSec = currentTimeInNanoSec;

                update(deltaInSec);
                paint();
            }
        }.start();

        primaryStage.setTitle("CarsRacerGame");
        primaryStage.show();
    }
}
