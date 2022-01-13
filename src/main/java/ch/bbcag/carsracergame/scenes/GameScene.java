package ch.bbcag.carsracergame.scenes;

import ch.bbcag.carsracergame.common.Cars;
import ch.bbcag.carsracergame.gameobjects.Car;
import ch.bbcag.carsracergame.gameobjects.Coin;
import ch.bbcag.carsracergame.gameobjects.Obstacle;
import ch.bbcag.carsracergame.common.scene.BaseScene;
import ch.bbcag.carsracergame.common.scene.Navigator;
import ch.bbcag.carsracergame.common.scene.SceneType;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class GameScene extends BaseScene {


    private Cars cars;
    private Car car;
    private AnimationTimer animationTimer;
    private long lastTimeInNanoSec;
    private Canvas canvas = new Canvas(800, 600);
    private GraphicsContext gc;
    private Image background = new Image(this.getClass().getResourceAsStream("/RadiatorSpringsBackground.png"));
    private String font = "src/main/resources/font.ttf";
    private List<Obstacle> obstacles = new ArrayList<>();
    private List<Coin> coins = new CopyOnWriteArrayList<>();
    private int score = 0;
    private Label label;
    public static int highscore;





    public GameScene(Navigator navigator, Cars cars) {
        super(navigator);
        this.cars = cars;

        car = cars.getCar();
        gc = canvas.getGraphicsContext2D();

        label = new Label();
        label.setFont(Font.loadFont((getClass().getResourceAsStream("/font.ttf")), 15));
        label.setLayoutX(625);
        label.setLayoutY(10);

        getGroup().getChildren().addAll(canvas, label);

        lastTimeInNanoSec = System.nanoTime();
    }

    public void update(double deltaInSec) {
        car.update(deltaInSec);
        spawnObstacles();
        spawnCoins();
        switchBackground();

        if (score > highscore) {
            highscore = score;
        }

        label.setText("Score: " + score);

        for (Obstacle obstacle : obstacles) {
            obstacle.update(deltaInSec, score);
            if (obstacle.collidesWithCar(car)) {
                score = 0;
                navigator.navigateTo(SceneType.END);
            }
        }

        for (Coin coin : coins) {
            coin.update(deltaInSec, score);
            if (coin.collidesWithCar(car)) {
                coins.remove(coin);
                score = score + 5;
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
                double deltaInSec = deltaInNanoSec / 1000000000d;

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

        int randInt = random.nextInt(600)+1;
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

    public void switchBackground() {
        if (score < 5) {
            background =  new Image(this.getClass().getResourceAsStream("/RadiatorSpringsBackground.png"));
        }
        if (score > 10) {
            background =  new Image(this.getClass().getResourceAsStream("/LosAngelesBackground.png"));
        }
        if (score > 15) {
            background = new Image(this.getClass().getResourceAsStream("/TokyoBackground.png"));
        }
        if (score > 20) {
            background = new Image(this.getClass().getResourceAsStream("/PortoCorsaBackground.png"));
        }
        if (score > 25) {
            background = new Image(this.getClass().getResourceAsStream("/LondonBackground"));
        }
    }


    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT) {
            car.setLeftKeyPressed(true);

        }
        else if (keyEvent.getCode() == KeyCode.RIGHT) {
            car.setRightKeyPressed(true);
        }
        else if (keyEvent.getCode() == KeyCode.A) {
            car.setIsaPressed(true);
        }
        else if (keyEvent.getCode() == KeyCode.D) {
            car.setIsdPressed(true);
        }
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT) {
            car.setLeftKeyPressed(false);
        }
        else if (keyEvent.getCode() == KeyCode.RIGHT) {
            car.setRightKeyPressed(false);
        }
        else if (keyEvent.getCode() == KeyCode.A) {
            car.setIsaPressed(false);
        }
        else if (keyEvent.getCode() == KeyCode.D) {
            car.setIsdPressed(false);
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
