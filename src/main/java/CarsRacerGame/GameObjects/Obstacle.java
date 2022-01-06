package CarsRacerGame.GameObjects;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Obstacle {
    private double Speed = 125;
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


}
