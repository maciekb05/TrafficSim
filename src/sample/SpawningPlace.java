package sample;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Set<Integer> setOfRandomGaps = new HashSet<>();
        Integer random;
        for (int i = 0; i < amountOfCars; i++) {
            random = rand.nextInt(RANGE);
            setOfRandomGaps.add(random);
        }

        List<Integer> sortedListOfRandomGaps = setOfRandomGaps.stream().sorted().collect(Collectors.toList());
        setOfRandomGaps.clear();

        for(int i = 0; i < sortedListOfRandomGaps.size() - 1; i++) {
            if(Math.abs(sortedListOfRandomGaps.get(i) - sortedListOfRandomGaps.get(i+1)) > 10) {
                setOfRandomGaps.add(sortedListOfRandomGaps.get(i));
            }
        }

        for (Integer randomGap : setOfRandomGaps) {
            random = rand.nextInt() % 100 + 1;
            if(random < getPercentChance()){
                Car car = spawnCar(spawningPoint, street, randomGap);
                Model.getInstance().addCar(car);
            }
        }
    }

    private Car spawnCar(Point spawningPoint, Street street, Integer gap){

        int randomX = 0, randomY = 0;

        Direction direction = street.getDirection();
        gap -= spawningPoint.getX();
        randomX -= gap;
        randomY = spawningPoint.getY();

        Car car = new Car(new Point( randomX,  randomY));
        car.setStreet(street);
        car.setCurrentSpeed(5);
        return car;
    }
}
