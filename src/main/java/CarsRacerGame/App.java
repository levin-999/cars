package CarsRacerGame;

import CarsRacerGame.common.enums.SceneType;
import CarsRacerGame.Views.EndScene;
import CarsRacerGame.Views.GameScene;
import CarsRacerGame.Views.HelpScene;
import CarsRacerGame.Views.StartScene;
import CarsRacerGame.common.Navigator;
import javafx.application.Application;
import javafx.scene.Group;
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

        primaryStage.setTitle("CarsRacerGame");
        primaryStage.show();
    }
}
