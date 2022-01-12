package CarsRacerGame.GameObjects;


import javafx.scene.control.Button;
import javafx.scene.text.Font;


public class Buttons extends Button {
    private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('yellow_button00.png')";

    public Buttons(String text) {
        setText(text);
        setButtonFont();
        setStyle(BUTTON_STYLE);
        setFont(Font.loadFont((getClass().getResourceAsStream("/font.ttf")), 15));
        setPrefSize(190, 49);

    }

    private void setButtonFont() {
        setFont(Font.font("", 23));
    }
}
