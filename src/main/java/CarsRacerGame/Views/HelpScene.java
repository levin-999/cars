package CarsRacerGame.Views;

import CarsRacerGame.GameObjects.Buttons;
import CarsRacerGame.common.BaseScene;
import CarsRacerGame.common.Navigator;
import CarsRacerGame.common.enums.SceneType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


import java.util.Collection;


public class HelpScene extends BaseScene {
    private Image backgroundImage = new Image(this.getClass().getResourceAsStream("/cars_wallpaper.jpg"));
    private GraphicsContext gc;
    private Canvas canvas;

    public HelpScene(Navigator navigator) {
        super(navigator);

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(backgroundImage, 0, 0);

        getGroup().getChildren().addAll(canvas);
        createButton();
    }
    public void setupScene() {

    }

    private void createButton() {
        Buttons button = new Buttons("Back");
        getGroup().getChildren().add(button);
        button.setOnAction(e -> navigator.navigateTo(SceneType.START));
        button.setLayoutY(500);
        button.setLayoutX(600);
    }

    @Override
    public void onEnter() {


    }

    @Override
    public void onExit() {

    }
}
