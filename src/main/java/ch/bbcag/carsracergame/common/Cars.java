package ch.bbcag.carsracergame.common;

import ch.bbcag.carsracergame.gameobjects.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();
    private int currentCar = 0;

    private List<String> imagePathList = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();
    private List<String> previewImagePathList = new ArrayList<>();


    public Cars() {
        //InGameBilder
        imagePathList.add("/lightningTopView.png");
        imagePathList.add("/luigiTopView.png");
        imagePathList.add("/MaterTopView.png");
        imagePathList.add("/guidoTopView.png");
        imagePathList.add("/SallyTopView.png");
        imagePathList.add("/FilmoreTopView.png");
        //Bilder der Charakterauswahl
        previewImagePathList.add("/lightningMcQueen.png");
        previewImagePathList.add("/Luigi.png");
        previewImagePathList.add("/Mater.png");
        previewImagePathList.add("/Guido.png");
        previewImagePathList.add("/Sally.png");
        previewImagePathList.add("/Filmore.png");

        nameList.add("Lightning");
        nameList.add("Luigi");
        nameList.add("Mater");
        nameList.add("Guido");
        nameList.add("Sally");
        nameList.add("Filmore");

        cars.add(new Car(imagePathList.get(0)));
        cars.add(new Car(imagePathList.get(1)));
        cars.add(new Car(imagePathList.get(2)));
        cars.add(new Car(imagePathList.get(3)));
        cars.add(new Car(imagePathList.get(4)));
        cars.add(new Car(imagePathList.get(5)));
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

    public String getPreviewImage(int index) {
        return previewImagePathList.get(index);
    }

    public String getName(int index) {
        return nameList.get(index);
    }
}
