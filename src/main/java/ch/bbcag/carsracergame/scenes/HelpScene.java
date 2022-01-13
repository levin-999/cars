package ch.bbcag.carsracergame.scenes;

import ch.bbcag.carsracergame.common.ArrowButton;
import ch.bbcag.carsracergame.common.scene.BaseScene;
import ch.bbcag.carsracergame.common.scene.Navigator;
import ch.bbcag.carsracergame.common.scene.SceneType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class HelpScene extends BaseScene {
    private Image backgroundImage = new Image(this.getClass().getResourceAsStream("/images/backgrounds/cars_wallpaper.jpg"));
    private Image textImage = new Image(this.getClass().getResourceAsStream("/images/menuItems/helpText.png"));
    private GraphicsContext gc;
    private Canvas canvas;

    public HelpScene(Navigator navigator) {
        super(navigator);

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(backgroundImage, 0, 0);
        gc.drawImage(textImage, 370, 170);

        getGroup().getChildren().addAll(canvas);
        createArrow();
    }

    private void createArrow() {
        ArrowButton goBackArrow = new ArrowButton(10, 10, SceneType.START, navigator);
        getGroup().getChildren().add(goBackArrow);
    }


    @Override
    public void onEnter() {


    }

    @Override
    public void onExit() {

    }
}
