package ch.bbcag.carsracergame.scenes;

import ch.bbcag.carsracergame.common.ImageButton;
import ch.bbcag.carsracergame.common.scene.BaseScene;
import ch.bbcag.carsracergame.common.scene.Navigator;
import ch.bbcag.carsracergame.common.scene.SceneType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


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


    private void createButton() {
        ImageButton button = new ImageButton("Back", 600, 500, SceneType.START, navigator);
        getGroup().getChildren().add(button);
    }

    @Override
    public void onEnter() {


    }

    @Override
    public void onExit() {

    }
}
