package ch.bbcag.carsracergame.common;

import ch.bbcag.carsracergame.gameobjects.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();
    private int currentCar = 0;

    private List<String> imagePathList = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();


    public Cars() {
        imagePathList.add("/cars_car.png");
        imagePathList.add("/Luigi.png");
        imagePathList.add("/Mater.png");
        nameList.add("Lightning");
        nameList.add("Luigi");
        nameList.add("Mater");
        cars.add(new Car(imagePathList.get(0)));
        cars.add(new Car(imagePathList.get(1)));
        cars.add(new Car(imagePathList.get(2)));
}

    public Car getCar() {
        return cars.get(currentCar);
    }

    public void setCurrentCar(int currentCar) {
        this.currentCar = currentCar;
    }

    public String getImage(int index) {
        return imagePathList.get(index);
    }
    public String getName(int index) {
        return nameList.get(index);
    }
}
