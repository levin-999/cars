package ch.bbcag.carsracergame.scenes;

import ch.bbcag.carsracergame.common.CharacterButton;
import ch.bbcag.carsracergame.common.scene.BaseScene;
import ch.bbcag.carsracergame.common.scene.Navigator;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;



public class CharacterScene extends BaseScene {
    private Canvas canvas;
    private GraphicsContext gc;
    private Image background = new Image(this.getClass().getResourceAsStream("/cars_wallpaper.jpg"));
    private HBox hbox = new HBox();
    private HBox hbox2 = new HBox();
    private Label label;

    public CharacterScene(Navigator navigator) {
        super(navigator);

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(background, 0, 0);

        //label.setText("Select your Character");
        //label.setLayoutX(200);
        //label.setLayoutY(100);

        CharacterButton car1 = new CharacterButton("/lightningMcQueen.png", "LightningMCQueen");
        CharacterButton car2 = new CharacterButton("/Guido.png", "Guido");
        CharacterButton car3 = new CharacterButton("/Luigi.png", "Luigi");
        CharacterButton car4 = new CharacterButton("/Mater.png", "Mater");
        CharacterButton car5 = new CharacterButton("/Sally.png", "Sally");
        CharacterButton car6 = new CharacterButton("/Filmore.png", "Filmore");

        hbox.getChildren().addAll(car1, car2, car3);
        car1.setAlignment(Pos.CENTER);
        car2.setAlignment(Pos.CENTER);
        car3.setAlignment(Pos.CENTER);
        hbox.setLayoutY(150);

        hbox2.getChildren().addAll(car4, car5, car6);
        car4.setAlignment(Pos.CENTER);
        car5.setAlignment(Pos.CENTER);
        car6.setAlignment(Pos.CENTER);
        hbox2.setLayoutY(350);

        getGroup().getChildren().addAll(canvas, hbox, hbox2);

    }





    @Override
    public void onEnter() {

    }

    @Override
    public void onExit() {

    }
}
