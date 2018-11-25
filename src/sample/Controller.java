package sample;

import javafx.scene.layout.Pane;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class Controller {

    Model model;
    Pane root;

    public Controller(Pane root) {
        this.root = root;
    }

    public void createModel() {
        Point A = new Point(400, 0);
        Point B = new Point(420, 0);
        Point C = new Point(300, 100);
        Point D = new Point(0, 200);
        Point E = new Point(400, 200);
        Point F = new Point(420, 200);
        Point G = new Point(600, 200);
        Point H = new Point(0, 220);
        Point I = new Point(400, 220);

        Point J = new Point(420, 220);
        Point K = new Point(600, 220);
        Point L = new Point(400, 400);
        Point M = new Point(420, 400);
        Point N = new Point(300, 200);

        Street czarnowiejskaEast = new Street(H, I, Direction.EAST);
        Street czarnowiejskaWest = new Street(E, D, Direction.WEST);
        Street parkKrakowskiNorth = new Street(N, C, Direction.NORTH);
        Street alejaSouthToCzarnowiejska = new Street(A, E, Direction.SOUTH);
        Street alejaNorthToCzarnowiejska = new Street(M, J, Direction.NORTH);
        Street alejaSouthFromCzarnowiejska = new Street(I, L, Direction.SOUTH);
        Street alejaNorthFromCzarnowiejska = new Street(F, B, Direction.NORTH);
        Street rynekEast = new Street(J, K, Direction.EAST);
        Street rynekWest = new Street(G, F, Direction.WEST);

        czarnowiejskaEast.setLeft(alejaNorthFromCzarnowiejska);
        czarnowiejskaEast.setStraight(rynekEast);
        czarnowiejskaEast.setRight(alejaSouthFromCzarnowiejska);

        czarnowiejskaWest.setLeft(null);
        czarnowiejskaWest.setStraight(null);
        czarnowiejskaWest.setRight(null);

        parkKrakowskiNorth.setLeft(null);
        parkKrakowskiNorth.setStraight(null);
        parkKrakowskiNorth.setRight(null);

        alejaSouthToCzarnowiejska.setLeft(rynekEast);
        alejaSouthToCzarnowiejska.setStraight(alejaSouthFromCzarnowiejska);
        alejaSouthToCzarnowiejska.setRight(czarnowiejskaWest);

        alejaNorthToCzarnowiejska.setLeft(czarnowiejskaWest);
        alejaNorthToCzarnowiejska.setStraight(alejaNorthFromCzarnowiejska);
        alejaNorthToCzarnowiejska.setRight(rynekEast);

        alejaSouthFromCzarnowiejska.setLeft(null);
        alejaSouthFromCzarnowiejska.setStraight(null);
        alejaSouthFromCzarnowiejska.setRight(null);

        alejaNorthFromCzarnowiejska.setLeft(null);
        alejaNorthFromCzarnowiejska.setStraight(null);
        alejaNorthFromCzarnowiejska.setRight(null);

        rynekEast.setLeft(null);
        rynekEast.setStraight(null);
        rynekEast.setRight(null);

        rynekWest.setLeft(alejaSouthFromCzarnowiejska);
        rynekWest.setStraight(czarnowiejskaWest);
        rynekWest.setRight(alejaNorthFromCzarnowiejska);

        model = new Model();

        model.streets.addAll(Arrays.asList(
                czarnowiejskaEast, czarnowiejskaWest,
                parkKrakowskiNorth,
                alejaSouthToCzarnowiejska, alejaNorthToCzarnowiejska,
                alejaSouthFromCzarnowiejska, alejaNorthFromCzarnowiejska,
                rynekEast, rynekWest)
        );
        model.spawningPlaces.add(new SpawningPlace(A, alejaSouthToCzarnowiejska, 60));
        model.spawningPlaces.add(new SpawningPlace(H, czarnowiejskaEast, 40));
        model.spawningPlaces.add(new SpawningPlace(M, alejaNorthToCzarnowiejska, 60));
        model.spawningPlaces.add(new SpawningPlace(G, rynekWest, 20));
    }

    public void spawnCars(){
        Random rand = new Random();
        model.spawningPlaces.forEach((place) -> {
            Integer random = rand.nextInt() % 100 + 1;
            if(random < place.getPercentChance()){
                Car car = spawnCar(place.getSpawningPoint(), place.getStreet());
                model.cars.add(car);
            }
        });
    }

    private Car spawnCar(Point spawningPoint, Street street){
        Car car = new Car(spawningPoint);
        car.setStreet(street);
        car.setCurrentSpeed(5);
        return car;
    }

    public void drive(){
        model.cars.forEach(Car::drive);
    }

}
