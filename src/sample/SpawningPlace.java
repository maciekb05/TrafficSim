package sample;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// miejsca w ktorych moga pojawiac sie auta
public class SpawningPlace {
    private Point spawningPoint;
    private Street street;
    private Integer percentChance;

    SpawningPlace(Point spawningPoint, Street street, Integer percentChance) {
        this.spawningPoint = spawningPoint;
        this.street = street;
        this.percentChance = percentChance;
    }

    // ustawianie samochodow na miejsca pojawiania
    void spawnCars(int amountOfCars){
        Random rand = new Random();

        Set<Point> points = new HashSet<>();

        Integer random;
        for (int i = 0; i < amountOfCars; i++) {
            random = rand.nextInt(street.getNumberOfPositions());
            if(street.getCars().get(random) == null) {
                street.getCars().set(random, spawnCar(street.getPointOfPosition(random), random));
            }
        }
    }

    // tworzenie samochodu
    private Car spawnCar(Point position,int random){
        Car car = new Car(position);
        car.setStreet(street);
        car.setCurrentSpeed(2);
        car.setCurrentPosition(random);
        Model.getInstance().getCars().add(car);
        return car;
    }
}
