package sample;

import java.util.Random;

public class SpawningPlace {
    private Point spawningPoint;
    private Street street;
    private Integer percentChance = 50;

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

    void spawnCars(){
        Random rand = new Random();
        Integer random = rand.nextInt() % 100 + 1;
        if(random < getPercentChance()){
            Car car = spawnCar(spawningPoint, street);
            Model.getInstance().getCars().add(car);
        }
    }

    private Car spawnCar(Point spawningPoint, Street street){
        Car car = new Car(spawningPoint);
        car.setStreet(street);
        car.setCurrentSpeed(5);
        return car;
    }
}
