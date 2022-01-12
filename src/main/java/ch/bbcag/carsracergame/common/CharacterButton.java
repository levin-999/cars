package ch.bbcag.carsracergame.common;


import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class CharacterButton extends VBox {
    private String imagePath;
    private Image image;
    private ImageButton button;
    private String carName;
    private ImageView imageView;

    public CharacterButton(String imagePath, String carName) {
        this.imagePath = imagePath;
        this.carName = carName;
        setImage();
        imageView = new ImageView();
        imageView.setImage(image);

        button = new ImageButton(carName);
        this.getChildren().addAll(imageView, button);
        this.setPadding(new Insets(40, 20, 50, 45));



    }

    private void setImage() {
        image = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(imagePath)));
    }


}
