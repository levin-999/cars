package CarsRacerGame;

import CarsRacerGame.Enums.SceneType;
import CarsRacerGame.GameObjects.Car;
import CarsRacerGame.Views.EndScene;
import CarsRacerGame.Views.GameScene;
import CarsRacerGame.Views.StartScene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class App extends Application {
    GraphicsContext gc;






    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigator navigator = new Navigator(primaryStage);
        navigator.registerScene(SceneType.START, new StartScene(navigator));
        navigator.registerScene(SceneType.GAME, new GameScene(navigator));
        navigator.registerScene(SceneType.END, new EndScene(navigator));
        navigator.navigateTo(SceneType.START);

        primaryStage.setTitle("CarsRacerGame");
        primaryStage.show();
    }
}
