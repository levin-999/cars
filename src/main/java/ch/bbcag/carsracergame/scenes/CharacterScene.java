package ch.bbcag.carsracergame.scenes;

import ch.bbcag.carsracergame.common.ArrowButton;
import ch.bbcag.carsracergame.common.Cars;
import ch.bbcag.carsracergame.common.CharacterButton;
import ch.bbcag.carsracergame.common.scene.BaseScene;
import ch.bbcag.carsracergame.common.scene.Navigator;
import ch.bbcag.carsracergame.common.scene.SceneType;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


public class CharacterScene extends BaseScene {

    private Cars cars;
    private Canvas canvas;
    private GraphicsContext gc;
    private Image background = new Image(this.getClass().getResourceAsStream("/images/backgrounds/cars_wallpaper.jpg"));
    private HBox hbox = new HBox();
    private HBox hbox2 = new HBox();
    private Label label;

    public CharacterScene(Navigator navigator, Cars cars) {
        super(navigator);

        this.cars = cars;
        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(background, 0, 0);

        label = new Label();
        label.setText("Select your Character");
        label.setFont(Font.loadFont((getClass().getResourceAsStream("/fonts/font.ttf")), 27));
        label.setLayoutX(80);
        label.setLayoutY(100);


        CharacterButton car0 = new CharacterButton(cars, 0);
        CharacterButton car1 = new CharacterButton(cars, 1);
        CharacterButton car2 = new CharacterButton(cars, 2);
        CharacterButton car3 = new CharacterButton(cars, 3);
        CharacterButton car4 = new CharacterButton(cars, 4);
        CharacterButton car5 = new CharacterButton(cars, 5);

        hbox.getChildren().addAll(car0, car1, car2);
        car0.setAlignment(Pos.CENTER);
        car1.setAlignment(Pos.CENTER);
        car2.setAlignment(Pos.CENTER);
        hbox.setLayoutY(150);

        hbox2.getChildren().addAll(car3, car4, car5);
        car3.setAlignment(Pos.CENTER);
        car4.setAlignment(Pos.CENTER);
        car5.setAlignment(Pos.CENTER);
        hbox2.setLayoutY(350);

        ArrowButton goBackArrow = new ArrowButton(10, 10, SceneType.START, navigator);

        getGroup().getChildren().addAll(canvas, hbox, hbox2, label, goBackArrow);

    }


    @Override
    public void onEnter() {

    }

    @Override
    public void onExit() {

    }
}
