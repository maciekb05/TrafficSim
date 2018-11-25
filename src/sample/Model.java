package sample;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model INSTANCE = new Model();
    private List<Street> streets = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private List<SpawningPlace> spawningPlaces = new ArrayList<>();
    private List<Point> points = new ArrayList<>();

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    private Model(){}

    public void addStreet(Street street){
        streets.add(street);
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void doNothing() {return;}

    public void deleteCar(Car car) { cars.remove(car);}

    public void addSpawningPlace(SpawningPlace place){
        spawningPlaces.add(place);
    }

    public void addPoint(Point point){
        points.add(point);
    }

    public static void setINSTANCE(Model INSTANCE) {
        Model.INSTANCE = INSTANCE;
    }

    List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    List<SpawningPlace> getSpawningPlaces() {
        return spawningPlaces;
    }

    public void setSpawningPlaces(List<SpawningPlace> spawningPlaces) {
        this.spawningPlaces = spawningPlaces;
    }

    static Model getInstance() {
        return INSTANCE;
    }
}
