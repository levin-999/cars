package CarsRacerGame.Views;

import CarsRacerGame.GameObjects.Buttons;
import CarsRacerGame.common.BaseScene;
import CarsRacerGame.common.Navigator;
import CarsRacerGame.common.enums.SceneType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class EndScene extends BaseScene {
    private Canvas canvas;
    private GraphicsContext gc;
    private Image image = new Image(this.getClass().getResourceAsStream("/GameOver.png"));
    private Image gameOverWallpaper = new Image(this.getClass().getResourceAsStream("/GameOverWallpaper.jpg"));


    public EndScene(Navigator navigator) {
        super(navigator);

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(gameOverWallpaper, 0, 0);
        gc.drawImage(image, 35, 10);

        getGroup().getChildren().add(canvas);
        createExitButton();
        createBackToStartButton();
    }

    
    
    private void createExitButton(){
        Buttons exitButton = new Buttons("Exit");
        getGroup().getChildren().add(exitButton);
        exitButton.setLayoutX(150);
        exitButton.setLayoutY(500);
        exitButton.setOnAction(event -> System.exit(0));
    }

    private void createBackToStartButton(){
        Buttons backButton = new Buttons("Back to Start");
        getGroup().getChildren().add(backButton);
        backButton.setLayoutX(150);
        backButton.setLayoutY(450);
        backButton.setOnAction(e -> navigator.navigateTo(SceneType.START));
    }

    @Override
    public void onEnter() {
        System.out.println("EndScene:onEnter");
    }

    @Override
    public void onExit() {
        System.out.println("EndScene:onExit");
    }
}
