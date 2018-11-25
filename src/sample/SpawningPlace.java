package sample;

import java.util.Random;

public class SpawningPlace {
    public static final int RANGE = 2000;
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
        for (int i = 0; i < amountOfCars; i++) {
            Integer random = rand.nextInt() % 100 + 1;
            if(random < getPercentChance()){
                Car car = spawnCar(spawningPoint, street);
                Model.getInstance().addCar(car);
            }
        }
    }

    private Car spawnCar(Point spawningPoint, Street street){
        Random rand = new Random();
        int randomX = 0, randomY = 0;
        Integer random = rand.nextInt(RANGE);
        switch (street.getDirection()) {
            case NORTH:
                random -= spawningPoint.getY();
                randomY -= random;
                break;
            case EAST:
                random += spawningPoint.getX();
                randomX += random;
                break;
            case SOUTH:
                random += spawningPoint.getY();
                randomY += random;
                break;
            case WEST:
                random -= spawningPoint.getX();
                randomX -= random;
                break;
        }
        Car car = new Car(new Point(spawningPoint.getX() + randomX, spawningPoint.getY()+randomY));
        car.setStreet(street);
        car.setCurrentSpeed(5);
        return car;
    }
}
