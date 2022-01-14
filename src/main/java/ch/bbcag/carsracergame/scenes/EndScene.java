package ch.bbcag.carsracergame.scenes;

import ch.bbcag.carsracergame.common.ImageButton;
import ch.bbcag.carsracergame.common.scene.BaseScene;
import ch.bbcag.carsracergame.common.scene.Navigator;
import ch.bbcag.carsracergame.common.scene.SceneType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;


public class EndScene extends BaseScene {
    private Canvas canvas;
    private GraphicsContext gc;
    private Image titleImage = new Image(this.getClass().getResourceAsStream("/images/menuItems/GameOver.png"));
    private Image gameOverWallpaper = new Image(this.getClass().getResourceAsStream("/images/backgrounds/GameOverWallpaper.jpg"));
    private Label label;


    public EndScene(Navigator navigator) {
        super(navigator);

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(gameOverWallpaper, 0, 0);
        gc.drawImage(titleImage, 35, 10);

        label = new Label();
        label.setText("Highscore: " + GameScene.highscore);
        label.setFont(Font.loadFont((getClass().getResourceAsStream("/fonts/font.ttf")), 27));
        label.setLayoutX(80);
        label.setLayoutY(120);

        getGroup().getChildren().addAll(canvas, label);
        createExitButton();
        createBackToStartButton();


    }


    private void createExitButton() {
        ImageButton exitButton = new ImageButton("Exit", 120, 370);
        getGroup().getChildren().add(exitButton);
        exitButton.setOnAction(event -> System.exit(0));
    }

    private void createBackToStartButton() {
        ImageButton backButton = new ImageButton("Menu", 120, 300, SceneType.START, navigator);
        getGroup().getChildren().add(backButton);
    }

    @Override
    public void onEnter() {
    }

    @Override
    public void onExit() {
    }
}
