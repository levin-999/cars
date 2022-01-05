package CarsRacerGame.Views;

import CarsRacerGame.Navigator;
import javafx.scene.Group;
import javafx.scene.Scene;

public class EndScene extends Scene {
    private Navigator navigator;
    private static Group root = new Group();

    public EndScene(Navigator navigator) {
        super(root);

        this.navigator = navigator;
    }
}
