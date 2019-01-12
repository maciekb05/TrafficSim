package sample;

import java.util.ArrayList;
import java.util.List;

//model danych na podstawie ktorej dziala symulacja
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

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    private Model(){}

    public void addSpawningPlace(SpawningPlace place){
        spawningPlaces.add(place);
    }

    List<Street> getStreets() {
        return streets;
    }

    List<Car> getCars() {
        return cars;
    }

    List<SpawningPlace> getSpawningPlaces() {
        return spawningPlaces;
    }

    static Model getInstance() {
        return INSTANCE;
    }

    public static void printStatistic(List<Street> streets) {

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
