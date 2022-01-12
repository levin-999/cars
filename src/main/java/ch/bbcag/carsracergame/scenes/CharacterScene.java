package ch.bbcag.carsracergame.scenes;

import ch.bbcag.carsracergame.common.ArrowButton;
import ch.bbcag.carsracergame.common.Cars;
import ch.bbcag.carsracergame.common.CharacterButton;
import ch.bbcag.carsracergame.common.ImageButton;
import ch.bbcag.carsracergame.common.scene.BaseScene;
import ch.bbcag.carsracergame.common.scene.Navigator;
import ch.bbcag.carsracergame.common.scene.SceneType;
import ch.bbcag.carsracergame.gameobjects.Car;
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
    private Image background = new Image(this.getClass().getResourceAsStream("/cars_wallpaper.jpg"));
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
        label.setFont(Font.loadFont((getClass().getResourceAsStream("/font.ttf")), 23));
        label.setLayoutX(120);
        label.setLayoutY(100);

//        CharacterButton car1 = new CharacterButton(cars,"/lightningMcQueen.png", "LightningMCQueen");
//        CharacterButton car2 = new CharacterButton(cars,"/Guido.png", "Guido");
//        CharacterButton car3 = new CharacterButton(cars,"/Luigi.png", "Luigi");
//        CharacterButton car4 = new CharacterButton(cars,"/Mater.png", "Mater");
//        CharacterButton car5 = new CharacterButton(cars,"/Sally.png", "Sally");
//        CharacterButton car6 = new CharacterButton(cars,"/Filmore.png", "Filmore");

        CharacterButton car1 = new CharacterButton(cars, 0);
        CharacterButton car2 = new CharacterButton(cars, 1);

        hbox.getChildren().addAll(car1, car2);
        car1.setAlignment(Pos.CENTER);
        car2.setAlignment(Pos.CENTER);
//        car3.setAlignment(Pos.CENTER);
        hbox.setLayoutY(150);

//        hbox2.getChildren().addAll(car4, car5, car6);
//        car4.setAlignment(Pos.CENTER);
//        car5.setAlignment(Pos.CENTER);
//        car6.setAlignment(Pos.CENTER);
//        hbox2.setLayoutY(350);

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
