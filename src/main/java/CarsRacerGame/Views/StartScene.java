package CarsRacerGame.Views;

import CarsRacerGame.Enums.SceneType;
import CarsRacerGame.Navigator;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class StartScene extends Scene {
    private Navigator navigator;
    private static Group root = new Group();
    private Image menuBackground = new Image(this.getClass().getResourceAsStream("/cars_wallpaper.jpg"));
    private Image startButton = new Image(this.getClass().getResourceAsStream("/start_button.png"));
    private Canvas canvas;
    private GraphicsContext gc;
    ImageView view = new ImageView(startButton);


    public StartScene(Navigator navigator) {
        super(root);

        this.navigator = navigator;

        canvas = new Canvas(800, 600);

        gc = canvas.getGraphicsContext2D();
        gc.drawImage(menuBackground, 0, 0);

        Button button = new Button();
        button.setGraphic(view);

        button.setOnAction(e -> navigator.navigateTo(SceneType.GAME));

        root.getChildren().addAll(canvas, button );
    }
}