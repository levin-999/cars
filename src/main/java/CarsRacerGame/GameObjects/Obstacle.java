package CarsRacerGame.GameObjects;


import javafx.geometry.BoundingBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Obstacle {
    private double Speed = 200;
    private double x;
    private double y;
    Canvas canvas;
    private Image image = new Image(this.getClass().getResourceAsStream("/cone_straight.png"));

    public Obstacle(double x, double y, Canvas canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
    }

    public void update(double deltaTimeInSec) {
        double distanceToMove = Speed * deltaTimeInSec;
        y = y + distanceToMove;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }

    public BoundingBox getBoundingBox() {
        return new BoundingBox(this.x, this.y, image.getWidth(), image.getHeight());
    }

    public boolean collidesWith(Car car) {
        return this.getBoundingBox().intersects(car.getBoundingBox());
    }
}
