package CarsRacerGame.Views;

import CarsRacerGame.GameObjects.Buttons;
import CarsRacerGame.common.BaseScene;
import CarsRacerGame.common.enums.SceneType;
import CarsRacerGame.common.Navigator;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class StartScene extends BaseScene {
    private Navigator navigator;
    private static Group root = new Group();
    private Image menuBackground = new Image(this.getClass().getResourceAsStream("/cars_wallpaper.jpg"));
    private Image quitButton = new Image(this.getClass().getResourceAsStream("/quitButton.png"));
    private final String BUTTON_STYLE = "-fxbackground-color: transparent; -fxbackground-image: url('/startGameButton.png')";
    private Image helpButton = new Image(this.getClass().getResourceAsStream("/helpButton.png"));
    private Canvas canvas;
    private GraphicsContext gc;


    public StartScene(Navigator navigator) {
        super(root);
        this.navigator = navigator;

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(menuBackground, 0, 0);


        root.getChildren().addAll(canvas);
        createStartButton();
    }

    private void createStartButton() {
        Buttons startButton = new Buttons("Start Game");
        root.getChildren().add(startButton);
        startButton.setLayoutX(500);
        startButton.setLayoutY(400);
        startButton.setOnAction(e -> navigator.navigateTo(SceneType.GAME));
    }

    private void createHelpButton() {
        Buttons helpButton = new Buttons("Start Game");
        root.getChildren().add(startButton);
        startButton.setLayoutX(500);
        startButton.setLayoutY(400);
        startButton.setOnAction(e -> navigator.navigateTo(SceneType.GAME));
    }


    @Override
    public void onEnter() {

    }

    @Override
    public void onExit() {

    }
}