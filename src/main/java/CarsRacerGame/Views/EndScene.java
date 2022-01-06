package CarsRacerGame.Views;

import CarsRacerGame.common.BaseScene;
import CarsRacerGame.common.Navigator;
import javafx.scene.Group;
import javafx.scene.Scene;

public class EndScene extends BaseScene {
    private Navigator navigator;
    private static Group root = new Group();

    public EndScene(Navigator navigator) {
        super(root);

        this.navigator = navigator;
    }

    @Override
    public void onEnter() {

    }

    @Override
    public void onExit() {

    }
}
