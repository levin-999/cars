package CarsRacerGame.Views;

import CarsRacerGame.common.Navigator;
import javafx.scene.Group;
import javafx.scene.Scene;

public class HelpScene extends Scene {
    private Navigator navigator;
    private static Group root = new Group();

    public HelpScene(Navigator navigator) {
        super(root);

        this.navigator = navigator;
    }
}
