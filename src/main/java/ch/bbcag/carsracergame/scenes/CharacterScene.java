package ch.bbcag.carsracergame.scenes;

import ch.bbcag.carsracergame.common.ArrowButton;
import ch.bbcag.carsracergame.common.Cars;
import ch.bbcag.carsracergame.common.CharacterButton;
import ch.bbcag.carsracergame.common.scene.BaseScene;
import ch.bbcag.carsracergame.common.scene.Navigator;
import ch.bbcag.carsracergame.common.scene.SceneType;
import com.sun.javafx.tk.Toolkit;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.util.Objects;


public class CharacterScene extends BaseScene {

    private Cars cars;
    private Canvas canvas;
    private GraphicsContext gc;
    private Image background = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/backgrounds/cars_wallpaper.jpg")));
    private Image yellowBox = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/menuItems/square.png")));
    private HBox hbox = new HBox();
    private HBox hbox2 = new HBox();
    private Label label;
    private Label label2;
    private Image selected;
    private long lastTimeInNanoSec;
    private AnimationTimer animationTimer;


    public CharacterScene(Navigator navigator, Cars cars) {
        super(navigator);
        this.cars = cars;

    }

    private void startScene() {
        AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long currentTimeInNanoSec) {


                long deltaInNanoSec = currentTimeInNanoSec - lastTimeInNanoSec;
                double deltaInSec = deltaInNanoSec / 1000000000d;

                lastTimeInNanoSec = currentTimeInNanoSec;

                update();
                paint();
            }
        };
        animationTimer.start();

        selected = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(cars.getPreviewImage(cars.getCurrentIndex()))));
        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(background, 0, 0);
        gc.drawImage(selected, 0, 0);
        gc.drawImage(yellowBox, 600, 10);


        setLabel("Select your character", 95, 50);
        setSecondLabel();


        CharacterButton car0 = new CharacterButton(cars, 0);
        CharacterButton car1 = new CharacterButton(cars, 1);
        CharacterButton car2 = new CharacterButton(cars, 2);
        CharacterButton car3 = new CharacterButton(cars, 3);
        CharacterButton car4 = new CharacterButton(cars, 4);
        CharacterButton car5 = new CharacterButton(cars, 5);

        createHBox(car0, car1, car2);

        hbox2.getChildren().addAll(car3, car4, car5);
        car3.setAlignment(Pos.CENTER);
        car4.setAlignment(Pos.CENTER);
        car5.setAlignment(Pos.CENTER);
        hbox2.setLayoutY(350);


        ArrowButton goBackArrow = new ArrowButton(10, 35, SceneType.START, navigator);

        getGroup().getChildren().addAll(canvas, hbox, hbox2, label, label2, goBackArrow);

    }

    private void createHBox(CharacterButton car0, CharacterButton car1, CharacterButton car2) {
        hbox.getChildren().addAll(car0, car1, car2);
        car0.setAlignment(Pos.CENTER);
        car1.setAlignment(Pos.CENTER);
        car2.setAlignment(Pos.CENTER);
        hbox.setLayoutY(150);
    }

    private void setLabel(String text, int x, int y) {
        label = new Label();
        label.setText(text);
        label.setFont(Font.loadFont((getClass().getResourceAsStream("/fonts/font.ttf")), 20));
        label.setLayoutX(x);
        label.setLayoutY(y);
    }


    private void setSecondLabel() {
        label2 = new Label("Your choice:");
        label2.setLayoutX(620);
        label2.setLayoutY(20);
        label2.setFont(Font.loadFont((getClass().getResourceAsStream("/fonts/font.ttf")), 14));

    }

    private void update() {
        selected = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(cars.getPreviewImage(cars.getCurrentIndex()))));
    }

    private void paint() {
        gc.drawImage(background, 0, 0);
        gc.drawImage(yellowBox, 600, 10);
        gc.drawImage(selected, 630, 70);
    }


    @Override
    public void onEnter() {
        startScene();
    }

    @Override
    public void onExit() {

    }
}
