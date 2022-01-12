package CarsRacerGame.Views;

import CarsRacerGame.GameObjects.Buttons;
import CarsRacerGame.common.BaseScene;
import CarsRacerGame.common.Navigator;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class EndScene extends BaseScene {
    private Navigator navigator;
    private static Group root = new Group();
    private Canvas canvas;
    private GraphicsContext gc;
    private Image image = new Image(this.getClass().getResourceAsStream("/GameOver.png"));

    public EndScene(Navigator navigator) {
        super(root);

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 20, 0);


        root.getChildren().add(canvas);

        this.navigator = navigator;
    }

    
    
    private void createExitButton(){
        Buttons exitButton = new Buttons("Exit");
        exitButton.setLayoutY(400);
        exitButton.setLayoutX(300);
    }

    @Override
    public void onEnter() {

    }

    @Override
    public void onExit() {

    }
}
