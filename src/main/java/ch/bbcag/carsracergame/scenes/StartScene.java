package ch.bbcag.carsracergame.scenes;

import ch.bbcag.carsracergame.common.ImageButton;
import ch.bbcag.carsracergame.common.scene.BaseScene;
import ch.bbcag.carsracergame.common.scene.SceneType;
import ch.bbcag.carsracergame.common.scene.Navigator;
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
        createCharacterButton();
    }

    private void createStartButton() {
        ImageButton startButton = new ImageButton("Game", 550, 330, SceneType.GAME, navigator);
        getGroup().getChildren().add(startButton);
    }

    private void createCharacterButton() {
        ImageButton characterButton = new ImageButton("Choose Car", 550, 390, SceneType.CHARACTER, navigator);
        characterButton.setFont(Font.loadFont((getClass().getResourceAsStream("/font.ttf")), 13));
        getGroup().getChildren().add(characterButton);
    }

    private void createHelpButton() {
        ImageButton helpButton = new ImageButton("Help", 550, 450, SceneType.HELP, navigator);
        getGroup().getChildren().add(helpButton);

    }

    private void createExitButton() {
        ImageButton exitButton = new ImageButton("Exit", 550, 510);
        getGroup().getChildren().add(exitButton);
        exitButton.setOnAction(event -> System.exit(0));
    }

    @Override
    public void onEnter() {
    }

    @Override
    public void onExit() {
    }
}