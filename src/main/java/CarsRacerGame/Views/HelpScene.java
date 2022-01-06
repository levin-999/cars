package CarsRacerGame.Views;

import CarsRacerGame.common.BaseScene;
import CarsRacerGame.common.Navigator;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;



public class HelpScene extends BaseScene {
    private Navigator navigator;
    private static Group root = new Group();
    private Image backgroundImage = new Image(this.getClass().getResourceAsStream("/cars_wallpaper.jpg"));
    private GraphicsContext gc;
    private Canvas canvas;

    public HelpScene(Navigator navigator) {
        super(root);
        this.navigator = navigator;

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(backgroundImage, 0, 0);


        root.getChildren().addAll(canvas);
    }

    public void setupScene() {

    }

    @Override
    public void onEnter() {


    }

    @Override
    public void onExit() {

    }
}
