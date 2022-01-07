package CarsRacerGame.GameObjects;


import javafx.scene.control.Button;
import javafx.scene.image.Image;


public class Buttons extends Button {
    private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('startGameButton.png')";

    public Buttons(String text) {
        setText(text);
        setStyle(BUTTON_STYLE);


    }


}
