package CarsRacerGame.Views;

import CarsRacerGame.common.BaseScene;
import CarsRacerGame.common.Navigator;
import CarsRacerGame.common.enums.SceneType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


import java.util.Collection;


public class HelpScene extends BaseScene {
    private Navigator navigator;
    private static Group root = new Group();
    private Image backgroundImage = new Image(this.getClass().getResourceAsStream("/cars_wallpaper.jpg"));
    private GraphicsContext gc;
    private Canvas canvas;

    public HelpScene(Navigator navigator) {
        super(root);
        this.navigator = navigator;

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(backgroundImage, 0, 0);

        Button button = new Button("Back");
        button.setOnAction(e -> navigator.navigateTo(SceneType.START));

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(button);
        vBox.setAlignment(Pos.BOTTOM_RIGHT);

        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(800, 600);
        borderPane.setRight(vBox);





        root.getChildren().addAll(canvas, borderPane);

    }
    public void setupScene() {

    }

    @Override
    public void onEnter() {


    }

    @Override
    public void onExit() {

    }
}
