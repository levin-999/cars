package CarsRacerGame.Views;

import CarsRacerGame.GameObjects.Car;
import CarsRacerGame.Navigator;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;


public class GameScene extends Scene {
    private Navigator navigator;
    private static Group root = new Group();
    private Canvas canvas = new Canvas(800, 600);
    private Car car = new Car(376, canvas);
    private GraphicsContext gc;

    public GameScene(Navigator navigator) {
        super(root);

        this.navigator = navigator;

        gc = canvas.getGraphicsContext2D();
        car.draw(gc);

        root.getChildren().addAll(canvas);

        //GameScene.setOnKeyPressed((e) -> onKeyPressed(e));
        //GameScene.setOnKeyReleased((e) -> onKeyReleased(e));

    }


    public void onKeyPressed(KeyEvent x) {

    }

    public void onKeyReleased(KeyEvent x) {

    }
}
