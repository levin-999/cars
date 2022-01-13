package ch.bbcag.carsracergame.common;


import ch.bbcag.carsracergame.common.scene.Navigator;
import ch.bbcag.carsracergame.common.scene.SceneType;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;


public class ImageButton extends Button {
    private final String BUTTON_RELEASED = "-fx-background-color: transparent; -fx-background-image: url('images/menuItems/yellow_button00.png')";
    private final String BUTTON_PRESSED = "-fx-background-color: transparent; -fx-background-image: url('images/menuItems/yellow_button01.png')";

    public ImageButton(String text, int x, int y) {
        setText(text);
        setFont(Font.loadFont((getClass().getResourceAsStream("/fonts/font.ttf")), 18));
        setPrefSize(190, 49);
        setLayoutY(y);
        setLayoutX(x);
        setStyle(BUTTON_RELEASED);
        pressedOrReleased();
    }

    public ImageButton(String text) {
        setText(text);
        setStyle(BUTTON_RELEASED);
        setFont(Font.loadFont((getClass().getResourceAsStream("/fonts/font.ttf")), 18));
        setPrefSize(190, 49);
        pressedOrReleased();
    }


    public ImageButton(String text, int x, int y, SceneType nextScene, Navigator navigator) {

        setText(text);
        setStyle(BUTTON_RELEASED);
        setFont(Font.loadFont((getClass().getResourceAsStream("/fonts/font.ttf")), 18));
        setPrefSize(190, 49);
        setOnAction(e -> navigator.navigateTo(nextScene));
        setLayoutY(y);
        setLayoutX(x);
        pressedOrReleased();
    }

    private void setButtonPressed() {
        setStyle(BUTTON_PRESSED);
        setLayoutY(getLayoutY() + 4);
        setPrefHeight(45);
    }

    private void setButtonReleased() {
        setStyle(BUTTON_RELEASED);
        setLayoutY(getLayoutY() - 20);
        setPrefHeight(49);
    }

    private void pressedOrReleased() {
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressed();
                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonReleased();
                }
            }
        });


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
