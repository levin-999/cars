package CarsRacerGame.common;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class BaseScene extends Scene {
    protected Navigator navigator;
    public BaseScene(Navigator navigator) {
        super(new Group());
        this.navigator = navigator;
    }

    public abstract void onEnter();
    public abstract void onExit();

    protected Group getGroup() {
        return (Group) getRoot();
    }
}
