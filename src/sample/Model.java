package sample;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model INSTANCE = new Model();
    private List<Street> streets = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private List<SpawningPlace> spawningPlaces = new ArrayList<>();

    private Model(){}

    public static Model getINSTANCE() {
        return INSTANCE;
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
