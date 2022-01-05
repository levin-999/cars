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
    private GraphicsContext gc;
    private long lastTime;

    public void update(long currentTime) {
        double deltaTime = (currentTime - lastTime) / 1e9;
        lastTime = currentTime;

        paint();
    }

    public void paint() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigator navigator = new Navigator(primaryStage);
        navigator.registerScene(SceneType.START, new StartScene(navigator));
        navigator.registerScene(SceneType.GAME, new GameScene(navigator));
        navigator.registerScene(SceneType.END, new EndScene(navigator));
        navigator.navigateTo(SceneType.GAME);

        lastTime = System.nanoTime();
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                update(l);
            }
        }.start();

        primaryStage.setTitle("CarsRacerGame");
        primaryStage.show();
    }
}
