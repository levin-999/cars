package CarsRacerGame.Views;

import CarsRacerGame.GameObjects.Car;
import CarsRacerGame.GameObjects.Coin;
import CarsRacerGame.GameObjects.Obstacle;
import CarsRacerGame.common.BaseScene;
import CarsRacerGame.common.Navigator;
import CarsRacerGame.common.enums.SceneType;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class GameScene extends BaseScene {
    private Navigator navigator;
    private AnimationTimer animationTimer;
    private long lastTimeInNanoSec;
    private static Group root = new Group();
    private Canvas canvas = new Canvas(800, 600);
    private GraphicsContext gc;
    private Image background = new Image(this.getClass().getResourceAsStream("/RadiatorSpringsBackground.png"));
    private Car car = new Car(376, canvas);
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private List<Coin> coins = new CopyOnWriteArrayList<Coin>();
    private int Score = 0;
    private Label label;
    private double MAX_FONT_SIZE = 30;


    public GameScene(Navigator navigator) {
        super(root);

        this.navigator = navigator;

        gc = canvas.getGraphicsContext2D();

        label = new Label();
        label.setFont(new Font("font.ttf", MAX_FONT_SIZE));
        label.setLayoutX(660);
        label.setLayoutY(10);

        root.getChildren().addAll(canvas, label);

        lastTimeInNanoSec = System.nanoTime();
    }

    public void update(double deltaInSec) {
        car.update(deltaInSec);
        spawnObstacles();
        spawnCoins();

        switchScenes();

        label.setText("Score: " + Score);

        for (Obstacle obstacle : obstacles) {
            obstacle.update(deltaInSec, Score);
            if (obstacle.collidesWith(car)) {
                Score = 0;
                navigator.navigateTo(SceneType.START);
            }
        }

        for (Coin coin : coins) {
            coin.update(deltaInSec, Score);
            if (coin.collidesWith(car)) {
                coins.remove(coin);
                Score = Score + 5;
            }
        }
    }

    public void paint() {
        gc.drawImage(background, 0, 0);

        car.draw(gc);

        for (Obstacle obstacle : obstacles) {
            obstacle.draw(gc);
        }

        for (Coin coin : coins) {
            coin.draw(gc);
        }
    }

    private void setupScene() {
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long currentTimeInNanoSec) {


                long deltaInNanoSec = currentTimeInNanoSec - lastTimeInNanoSec;
                double deltaInSec = deltaInNanoSec / 1000000000d; //oder: 1e9;

                lastTimeInNanoSec = currentTimeInNanoSec;

                update(deltaInSec);
                paint();
            }
        };
        animationTimer.start();

        this.setOnKeyPressed((e) -> onKeyPressed(e));
        this.setOnKeyReleased((e) -> onKeyReleased(e));
    }

    public void spawnObstacles() {
        Random random = new Random();

        int randInt = random.nextInt(700)+1;
        int randY = random.nextInt(500)-500;
        double dRandY = Double.valueOf(randY);

        if (randInt < 10) {
            int randLane = random.nextInt(5)+1;
            if (randLane == 1) {
                obstacles.add(new Obstacle(223, dRandY, canvas));
            }
            else if (randLane == 2) {
                obstacles.add(new Obstacle(323, dRandY, canvas));
            }
            else if (randLane == 3) {
                obstacles.add(new Obstacle(423, dRandY, canvas));
            }
            else if (randLane == 4) {
                obstacles.add(new Obstacle(523, dRandY, canvas));
            }
        }
    }

    public void spawnCoins() {
        Random random = new Random();

        int randInt = random.nextInt(2000)+1;
        int randY = random.nextInt(500)-500;
        double dRandY = Double.valueOf(randY);

        if (randInt < 10) {
            int randLane = random.nextInt(4)+1;
            if (randLane == 1) {
                coins.add(new Coin(223, dRandY, canvas));
            }
            else if (randLane == 2) {
                coins.add(new Coin(323, dRandY, canvas));
            }
            else if (randLane == 3) {
                coins.add(new Coin(423, dRandY, canvas));
            }
            else if (randLane == 4) {
                coins.add(new Coin(523, dRandY, canvas));
            }
        }
    }

    public void switchScenes() {
        if (Score < 25) {
            background =  new Image(this.getClass().getResourceAsStream("/RadiatorSpringsBackground.png"));
        }
        if (Score > 25) {
            background =  new Image(this.getClass().getResourceAsStream("/LosAngelesBackground.png"));
        }
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT) {
            car.setLeftKeyPressed(true);

        }
        else if (keyEvent.getCode() == KeyCode.RIGHT) {
            car.setRightKeyPressed(true);
        }
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT) {
            car.setLeftKeyPressed(false);
        }
        else if (keyEvent.getCode() == KeyCode.RIGHT) {
            car.setRightKeyPressed(false);
        }
    }

    @Override
    public void onEnter() {
        setupScene();
    }

    @Override
    public void onExit() {
        animationTimer.stop();
    }
}
