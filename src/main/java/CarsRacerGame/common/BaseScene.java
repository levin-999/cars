package CarsRacerGame.common;

import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class BaseScene extends Scene {
    public BaseScene(Parent root) {
        super(root);
    }

    public abstract void onEnter();
    public abstract void onExit();
}
