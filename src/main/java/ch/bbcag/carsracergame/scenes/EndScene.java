package ch.bbcag.carsracergame.scenes;

import ch.bbcag.carsracergame.common.ImageButton;
import ch.bbcag.carsracergame.common.scene.BaseScene;
import ch.bbcag.carsracergame.common.scene.Navigator;
import ch.bbcag.carsracergame.common.scene.SceneType;
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
        ImageButton exitButton = new ImageButton("Exit", 150, 500);
        getGroup().getChildren().add(exitButton);
        exitButton.setOnAction(event -> System.exit(0));
    }

    private void createBackToStartButton(){
        ImageButton backButton = new ImageButton("Back to Start", 150, 450, SceneType.START, navigator);
        getGroup().getChildren().add(backButton);
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
