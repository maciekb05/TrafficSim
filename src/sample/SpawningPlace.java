package sample;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpawningPlace {
    private Point spawningPoint;
    private Street street;
    private Integer percentChance;

    SpawningPlace(Point spawningPoint, Street street, Integer percentChance) {
        this.spawningPoint = spawningPoint;
        this.street = street;
        this.percentChance = percentChance;
    }

    public Point getSpawningPoint() {
        return spawningPoint;
    }

    public void setSpawningPoint(Point spawningPoint) {
        this.spawningPoint = spawningPoint;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Integer getPercentChance() {
        return percentChance;
    }

    public void setPercentChance(Integer percentChance) {
        this.percentChance = percentChance;
    }

    void spawnCars(int amountOfCars){
        Random rand = new Random();

        //todo: Maciek unikalne auta w polu
        Integer random;
        for (int i = 0; i < amountOfCars; i++) {
            random = rand.nextInt(street.getNumberOfPositions());
            street.getCars().set(random, spawnCar(street.getPointOfPosition(random)));
        }
    }

    private Car spawnCar(Point position){
        Car car = new Car(position);
        car.setStreet(street);
        car.setCurrentSpeed(25);
        Model.getInstance().getCars().add(car);
        return car;
    }
}
