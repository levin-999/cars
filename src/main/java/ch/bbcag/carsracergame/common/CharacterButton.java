package ch.bbcag.carsracergame.common;


import ch.bbcag.carsracergame.gameobjects.Car;
import ch.bbcag.carsracergame.scenes.GameScene;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class CharacterButton extends VBox {

    private Cars cars;
    private String imagePath;
    private Image image;
    private ImageButton button;
    private String carName;
    private ImageView imageView;


    public CharacterButton(Cars cars, int carIndex) {
        this.imagePath = cars.getImage(carIndex);
        this.carName = cars.getName(carIndex);
        setImage();
        imageView = new ImageView();
        imageView.setImage(image);

        button = new ImageButton(carName);
        this.getChildren().addAll(imageView, button);
        this.setPadding(new Insets(40, 20, 50, 45));
        button.setOnAction(e -> cars.setCurrentCar(carIndex));


    }

    private void setImage() {
        image = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(imagePath)));
    }


}
