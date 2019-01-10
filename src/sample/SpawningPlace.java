package sample;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

        Set<Point> points = new HashSet<>();
        //done: Maciek unikalne auta w polu
        Integer random;
        for (int i = 0; i < amountOfCars; i++) {
            random = rand.nextInt(street.getNumberOfPositions());
            if(street.getCars().get(random) == null) {
                street.getCars().set(random, spawnCar(street.getPointOfPosition(random), random));
            }
        }
    }

    private Car spawnCar(Point position,int random){
        Car car = new Car(position);
        car.setStreet(street);
        car.setCurrentSpeed(2);
        car.setCurrentPosition(random);
        Model.getInstance().getCars().add(car);
        return car;
    }
}
