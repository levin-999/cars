package CarsRacerGame.Views;

import CarsRacerGame.GameObjects.Buttons;
import CarsRacerGame.common.BaseScene;
import CarsRacerGame.common.enums.SceneType;
import CarsRacerGame.common.Navigator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class StartScene extends BaseScene {
    private Navigator navigator;
    private static Group root = new Group();
    private Image menuBackground = new Image(this.getClass().getResourceAsStream("/cars_wallpaper.jpg"));
    private Image quitButton = new Image(this.getClass().getResourceAsStream("/quitButton.png"));
    //private Image startGameButton = new Image(this.getClass().getResourceAsStream("/startGameButton.png"));
    private final String BUTTON_STYLE = "-fxbackground-color: transparent; -fxbackground-image: url('/startGameButton.png')";
    private Image helpButton = new Image(this.getClass().getResourceAsStream("/helpButton.png"));
    private Canvas canvas;
    private GraphicsContext gc;
    //private ImageView view1 = new ImageView(startGameButton);
    //private ImageView view2 = new ImageView(helpButton);
    //private ImageView view3 = new ImageView(quitButton);

    public StartScene(Navigator navigator) {
        super(root);
        this.navigator = navigator;

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(menuBackground, 0, 0);

        Button button1 = new Button();
        button1.setLayoutX(100);
        button1.setLayoutY(500);
        //Button button2 = new Button();
        //Button button3 = new Button();
        //button1.setGraphic(view1);
        //button2.setGraphic(view2);
        //button3.setGraphic(view3);
        //view3.setFitWidth(100);
        //view3.setPreserveRatio(true);

        button1.setOnAction(e -> navigator.navigateTo(SceneType.GAME));
        //button2.setOnAction(e -> navigator.navigateTo(SceneType.HELP));

        //VBox vBox = new VBox();
        //vBox.setPadding(new Insets(100));
        //vBox.getChildren().addAll(button1);
        //vBox.setAlignment(Pos.CENTER_RIGHT);




        //BorderPane borderPane = new BorderPane();
        //borderPane.setMinSize(800, 600);
        //borderPane.setPadding(new Insets(20));
        //borderPane.setBottom(vBox);


        root.getChildren().addAll(canvas, button1);
        createButton();
    }

    private void createButton() {
        Buttons button = new Buttons("");
        root.getChildren().add(button);
    }



    @Override
    public void onEnter() {

    }

    @Override
    public void onExit() {

    }
}