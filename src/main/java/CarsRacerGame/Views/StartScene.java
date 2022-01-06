package CarsRacerGame.Views;

import CarsRacerGame.common.enums.SceneType;
import CarsRacerGame.common.Navigator;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class StartScene extends Scene {
    private Navigator navigator;
    private static Group root = new Group();
    private Image menuBackground = new Image(this.getClass().getResourceAsStream("/cars_wallpaper.jpg"));
    private Image quitButton = new Image(this.getClass().getResourceAsStream("/quitButton.png"));
    private Image startGameButton = new Image(this.getClass().getResourceAsStream("/startGameButton.png"));
    private Image helpButton = new Image(this.getClass().getResourceAsStream("/quitButton.png"));
    private Canvas canvas;
    private GraphicsContext gc;
    private ImageView view1 = new ImageView(quitButton);
    private ImageView view2 = new ImageView(helpButton);
    private ImageView view3 = new ImageView(quitButton);

    public StartScene(Navigator navigator) {
        super(root);
        this.navigator = navigator;

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(menuBackground, 0, 0);




        //view.setPreserveRatio(true);

        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        button1.setGraphic(view1);
        button2.setGraphic(view2);
        button3.setGraphic(view3);
        button1.setOnAction(e -> navigator.navigateTo(SceneType.GAME));
        button2.setOnAction(e -> navigator.navigateTo(SceneType.HELP));


        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(button1, button2, button3);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(vBox);

        //BorderPane borderPane1 = new BorderPane();
        //borderPane1.setBottom(borderPane);

        root.getChildren().addAll(canvas, borderPane);
    }
}