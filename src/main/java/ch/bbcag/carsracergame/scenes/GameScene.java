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
import java.net.URL;
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
    private Image background = new Image(this.getClass().getResourceAsStream("/images/backgrounds/RadiatorSpringsBackground.png"));
    private String font = "src/main/resources/font.ttf";
    private List<Obstacle> obstacles = new CopyOnWriteArrayList<>();
    private List<Coin> coins = new CopyOnWriteArrayList<>();
    private int score = 0;
    private Label label;
    public static int highscore;
    private int coinSpawnBound = 1000;
    private int obstacleSpawnBound = 450;






    private URL audio1Path = getClass().getResource("/audio/LifeIsAHighway.mp3");
    private Media audio1 = new Media(audio1Path.toString());
    private MediaPlayer mediaPlayer1 = new MediaPlayer(audio1);

    private URL audio2Path = getClass().getResource("/audio/RealGone.mp3");
    private Media audio2 = new Media(audio2Path.toString());
    private MediaPlayer mediaPlayer2 = new MediaPlayer(audio2);

    private URL audio3Path = getClass().getResource("/audio/TokyoDrift.mp3");
    private Media audio3 = new Media(audio3Path.toString());
    private MediaPlayer mediaPlayer3 = new MediaPlayer(audio3);

    private URL audio4Path = getClass().getResource("/audio/TarantellaNapoletana.mp3");
    private Media audio4 = new Media(audio4Path.toString());
    private MediaPlayer mediaPlayer4 = new MediaPlayer(audio4);

    private URL audio5Path = getClass().getResource("/audio/DayInTheLife.mp3");
    private Media audio5 = new Media(audio5Path.toString());
    private MediaPlayer mediaPlayer5 = new MediaPlayer(audio5);

    private URL audio6Path = getClass().getResource("/audio/MyHouse.mp3");
    private Media audio6 = new Media(audio6Path.toString());
    private MediaPlayer mediaPlayer6 = new MediaPlayer(audio6);




    public GameScene(Navigator navigator, Cars cars) {
        super(navigator);
        this.cars = cars;

        car = cars.getCar();
        gc = canvas.getGraphicsContext2D();

        label = new Label();
        label.setFont(Font.loadFont((getClass().getResourceAsStream("/fonts/font.ttf")), 15));
        label.setLayoutX(625);
        label.setLayoutY(10);

        getGroup().getChildren().addAll(canvas, label);

        lastTimeInNanoSec = System.nanoTime();
    }

    public void update(double deltaInSec) {
        car.update(deltaInSec);
        spawnObstacles();
        deleteObjects();
        spawnCoins();
        switchThemes();
        updateHighscore();
        checkCollisions(deltaInSec);
        label.setText("Score: " + score);
    }

    public void paint() {
        gc.drawImage(background, 0, 0);
        drawGameObjects();
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

    private void spawnObstacles() {
        Random random = new Random();



        int randInt = random.nextInt(obstacleSpawnBound)+1;
        int randY = random.nextInt(500)-1000;
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

    private void spawnCoins() {
        Random random = new Random();

        int randInt = random.nextInt(coinSpawnBound)+1;
        int randY = random.nextInt(500)-1000;
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

    private void switchThemes() {
        mediaPlayer1.setVolume(0.04);
        mediaPlayer2.setVolume(0.04);
        mediaPlayer3.setVolume(0.04);
        mediaPlayer4.setVolume(0.04);
        mediaPlayer5.setVolume(0.04);
        mediaPlayer6.setVolume(0.04);

        if (score < 5) {
            background =  new Image(this.getClass().getResourceAsStream("/images/backgrounds/RadiatorSpringsBackground.png"));
            mediaPlayer1.play();
        }
        if (score > 25) {
            background =  new Image(this.getClass().getResourceAsStream("/images/backgrounds/LosAngelesBackground.png"));
            mediaPlayer1.stop();
            mediaPlayer2.play();
            if (obstacleSpawnBound > 400) {
                obstacleSpawnBound = obstacleSpawnBound - 50;
            }
        }
        if (score > 50) {
            background = new Image(this.getClass().getResourceAsStream("/images/backgrounds/TokyoBackground.png"));
            mediaPlayer2.stop();
            mediaPlayer3.play();
            if (obstacleSpawnBound > 350) {
                obstacleSpawnBound = obstacleSpawnBound - 50;
            }
        }
        if (score > 75) {
            background = new Image(this.getClass().getResourceAsStream("/images/backgrounds/PortoCorsaBackground.png"));
            mediaPlayer3.stop();
            mediaPlayer4.play();
            if (obstacleSpawnBound > 300) {
                obstacleSpawnBound = obstacleSpawnBound - 50;
            }
        }
        if (score > 100) {
            background = new Image(this.getClass().getResourceAsStream("/images/backgrounds/LondonBackground.png"));
            mediaPlayer4.stop();
            mediaPlayer5.play();
            if (obstacleSpawnBound > 250) {
                obstacleSpawnBound = obstacleSpawnBound - 50;
            }
        }
        if (score > 125) {
            background = new Image(this.getClass().getResourceAsStream("/images/backgrounds/FloridaBackground.png"));
            mediaPlayer5.stop();
            mediaPlayer6.play();
            if (obstacleSpawnBound > 200) {
                obstacleSpawnBound = obstacleSpawnBound - 50;
            }
        }
    }




    private void onKeyPressed(KeyEvent keyEvent) {
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

    private void onKeyReleased(KeyEvent keyEvent) {
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

    private void updateHighscore() {
        if (score > highscore) {
            highscore = score;
        }
    }

    private void checkCollisions(double deltaInSec) {
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

    private void drawGameObjects() {
        car.draw(gc);

        for (Obstacle obstacle : obstacles) {
            obstacle.draw(gc);
        }

        for (Coin coin : coins) {
            coin.draw(gc);
        }
    }

    private void deleteObjects() {
        for (Obstacle obstacle : obstacles) {
            double y = obstacle.getY();
            if (y > 600) {
                obstacles.remove(obstacle);
            }
        }

        for (Coin coin : coins ) {
            double y = coin.getY();
            if (y > 600) {
                coins.remove(coin);
            }
        }
    }

    @Override
    public void onEnter() {
        setupScene();
    }

    @Override
    public void onExit() {
        animationTimer.stop();
        mediaPlayer1.stop();
        mediaPlayer2.stop();
        mediaPlayer3.stop();
        mediaPlayer4.stop();
        mediaPlayer5.stop();
        mediaPlayer6.stop();
    }
}
