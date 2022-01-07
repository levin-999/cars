package CarsRacerGame.GameObjects;

import javafx.geometry.BoundingBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Car {
    private double CarSpeed = 300;
    private double x;
    private static final double y = 400;
    private boolean isLeftKeyPressed = false;
    private boolean isRightKeyPressed = false;
    private Canvas canvas;
    private Image image = new Image(this.getClass().getResourceAsStream("/cars_car.png"));

    public Car(double x, Canvas canvas) {
        this.x = x;
        this.canvas = canvas;
    }

    public void update(double deltaTimeInSec) {
        double distanceToMove = CarSpeed * deltaTimeInSec;
        moveCar(distanceToMove);
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }

    public void moveCar(double distanceToMove) {
        if (isLeftKeyPressed && x > 210) {
            x = x -distanceToMove;
        }
        else if (isRightKeyPressed && x < 540) {
            x = x + distanceToMove;
        }

    }

    public void setLeftKeyPressed(boolean leftKeyPressed) {
        isLeftKeyPressed = leftKeyPressed;
    }

    public void setRightKeyPressed(boolean rightKeyPressed) {
        isRightKeyPressed = rightKeyPressed;
    }

    public BoundingBox getBoundingBox() {
        return new BoundingBox(this.x, this.y, image.getWidth(), image.getHeight());
    }
}
