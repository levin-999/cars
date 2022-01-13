package ch.bbcag.carsracergame.common;


import ch.bbcag.carsracergame.common.scene.Navigator;
import ch.bbcag.carsracergame.common.scene.SceneType;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class ArrowButton extends Button {
    private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('yellowArrow.png')";

    public ArrowButton(int x, int y, SceneType nextScene, Navigator navigator) {
        setStyle(BUTTON_STYLE);
        setPrefSize(75, 60);
        setOnAction(e -> navigator.navigateTo(nextScene));
        setLayoutY(y);
        setLayoutX(x);
        initializeButton();
    }


    private void initializeButton() {
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(new DropShadow());

            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(null);

            }
        });

    }
}