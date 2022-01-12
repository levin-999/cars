package ch.bbcag.carsracergame.common;


import ch.bbcag.carsracergame.common.scene.enums.Navigator;
import ch.bbcag.carsracergame.common.scene.enums.SceneType;
import javafx.scene.control.Button;
import javafx.scene.text.Font;


public class ImageButton extends Button {
    private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('yellow_button00.png')";

    public ImageButton(String text, int x, int y) {

        setText(text);
        setButtonFont();
        setStyle(BUTTON_STYLE);
        setFont(Font.loadFont((getClass().getResourceAsStream("/font.ttf")), 15));
        setPrefSize(190, 49);
        setLayoutY(y);
        setLayoutX(x);
    }


    public ImageButton(String text, int x, int y, SceneType nextScene, Navigator navigator) {

        setText(text);
        setButtonFont();
        setStyle(BUTTON_STYLE);
        setFont(Font.loadFont((getClass().getResourceAsStream("/font.ttf")), 15));
        setPrefSize(190, 49);


        setOnAction(e -> navigator.navigateTo(nextScene));
        setLayoutY(y);
        setLayoutX(x);
    }

    private void setButtonFont() {
        setFont(Font.font("", 23));
    }
}
