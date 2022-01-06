package CarsRacerGame.Views;

import CarsRacerGame.GameObjects.Car;
import CarsRacerGame.Navigator;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;


public class GameScene extends Scene {
    private Navigator navigator;
    private long lastTimeInNanoSec;
    private static Group root = new Group();
    private Canvas canvas = new Canvas(800, 600);
    private Car car = new Car(376, canvas);
    private GraphicsContext gc;
    private javafx.scene.image.Image Background = new Image(this.getClass().getResourceAsStream("/cars_wallpaper.jpg"));

    public GameScene(Navigator navigator) {
        super(root);

        lastTimeInNanoSec = System.nanoTime();

        new AnimationTimer() {
            @Override
            public void handle(long currentTimeInNanoSec) {

                long deltaInNanoSec = currentTimeInNanoSec - lastTimeInNanoSec;
                double deltaInSec = deltaInNanoSec / 1000000000d;

                lastTimeInNanoSec = currentTimeInNanoSec;

                update(deltaInSec);
                paint();
            }
        }.start();

        this.navigator = navigator;

        gc = canvas.getGraphicsContext2D();

        root.getChildren().addAll(canvas);

        this.setOnKeyPressed((e) -> onKeyPressed(e));
        this.setOnKeyReleased((e) -> onKeyReleased(e));
    }

    public void update(double deltaInSec) {
        car.update(deltaInSec);
    }

    public void paint() {
        gc.drawImage(Background, 0, 0);
        car.draw(gc);
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT) {
            car.setLeftKeyPressed(true);
        }
        else if (keyEvent.getCode() == KeyCode.RIGHT) {
            car.setRightKeyPressed(true);
        }
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT) {
            car.setLeftKeyPressed(false);
        }
        else if (keyEvent.getCode() == KeyCode.RIGHT) {
            car.setRightKeyPressed(false);
        }
    }
}
