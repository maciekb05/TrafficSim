package sample;

import javafx.scene.shape.Circle;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model INSTANCE = new Model();
    private List<Street> streets = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private List<SpawningPlace> spawningPlaces = new ArrayList<>();
    private List<Point> points = new ArrayList<>();
    private List<Light> lights = new ArrayList<>();

    public List<Light> getLights() {
        return lights;
    }

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

    public static void printStatistic(List<Street> streets) {
        List<Street> north = streets.subList(0,2);
        List<Street> west = streets.subList(5,7);
        List<Street> south = streets.subList(10,12);
        List<Street> east = streets.subList(15,17);

        Integer north_counter = 0;
        Integer west_counter = 0;
        Integer south_counter = 0;
        Integer east_counter = 0;

        for (int i=0;i<3;i++){
            north_counter += streets.get(i).getCounter();
            west_counter += streets.get(i+5).getCounter();
            south_counter += streets.get(i+10).getCounter();
            east_counter += streets.get(i+15).getCounter();
        }

        System.out.println("Statystyki:\n North: "+north_counter+ "  West: "+west_counter+"  South: "+south_counter+" East: "+east_counter+"\n");

    }
}
