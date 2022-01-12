package CarsRacerGame.Views;

import CarsRacerGame.GameObjects.Buttons;
import CarsRacerGame.common.BaseScene;
import CarsRacerGame.common.enums.SceneType;
import CarsRacerGame.common.Navigator;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;


public class StartScene extends BaseScene {
    private Image menuBackground = new Image(this.getClass().getResourceAsStream("/cars_wallpaper.jpg"));
    private Canvas canvas;
    private GraphicsContext gc;


    public StartScene(Navigator navigator) {
        super(navigator);

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(menuBackground, 0, 0);


        getGroup().getChildren().addAll(canvas);
        createStartButton();
        createHelpButton();
        createExitButton();
    }

    private void createStartButton() {
        Buttons startButton = new Buttons("Start");
        getGroup().getChildren().add(startButton);
        startButton.setLayoutX(420);
        startButton.setLayoutY(350);
        startButton.setOnAction(e -> navigator.navigateTo(SceneType.GAME));
    }

    private void createHelpButton() {
        Buttons helpButton = new Buttons("Help");
        getGroup().getChildren().add(helpButton);
        helpButton.setLayoutX(420);
        helpButton.setLayoutY(420);
        helpButton.setOnAction(e -> navigator.navigateTo(SceneType.HELP));
    }

    private void createExitButton() {
        Buttons exitButton = new Buttons("Exit");
        getGroup().getChildren().add(exitButton);
        exitButton.setLayoutX(420);
        exitButton.setLayoutY(490);
        exitButton.setOnAction(event -> System.exit(0));
    }

    @Override
    public void onEnter() {
        System.out.println("StartScene:onEnter");
    }

    @Override
    public void onExit() {
        System.out.println("StartScene:onExit");
    }
}