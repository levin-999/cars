package CarsRacerGame.GameObjects;


import javafx.scene.control.Button;
import javafx.scene.text.Font;


public class Buttons extends Button {
    private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('blue_button00.png')";
    //private final String FONT_PATH = "src/main/resources/font.ttf";

    public Buttons(String text) {
        setText(text);
        setButtonFont();
        setStyle(BUTTON_STYLE);
        setPrefSize(190, 49);

    }

    private void setButtonFont() {
        setFont(Font.font("", 23));
    }
}
