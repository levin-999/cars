package ch.bbcag.carsracergame.common;


import ch.bbcag.carsracergame.common.scene.Navigator;
import ch.bbcag.carsracergame.common.scene.SceneType;
import javafx.scene.control.Button;

public class ArrowButton extends Button {
    private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('yellowArrow.png')";

    public ArrowButton( int x, int y, SceneType nextScene, Navigator navigator) {
        setStyle(BUTTON_STYLE);
        setPrefSize(75, 60);
        setOnAction(e -> navigator.navigateTo(nextScene));
        setLayoutY(y);
        setLayoutX(x);
    }

}
