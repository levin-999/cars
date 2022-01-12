package ch.bbcag.carsracergame.scenes;

import ch.bbcag.carsracergame.common.ImageButton;
import ch.bbcag.carsracergame.common.scene.enums.BaseScene;
import ch.bbcag.carsracergame.common.scene.enums.SceneType;
import ch.bbcag.carsracergame.common.scene.enums.Navigator;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


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
        ImageButton startButton = new ImageButton("Start", 420, 350, SceneType.GAME, navigator);
        getGroup().getChildren().add(startButton);
        startButton.setLayoutX(420);
        startButton.setLayoutY(350);
        startButton.setOnAction(e -> navigator.navigateTo(SceneType.GAME));
    }

    private void createHelpButton() {
        ImageButton helpButton = new ImageButton("Help", 420, 420, SceneType.HELP, navigator);
        getGroup().getChildren().add(helpButton);

    }

    private void createExitButton() {
        ImageButton exitButton = new ImageButton("Exit", 420, 490);
        getGroup().getChildren().add(exitButton);
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