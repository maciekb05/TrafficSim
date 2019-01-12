package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

// klasa reprezentujaca ulice
public class Street {
    // jaka ulica jest po skrecie w lewo, prawo, prosto
    private Street left = null;
    private Street right = null;
    private Street straight = null;
    // limit predkosci na ulicy
    private Integer speedLimit = 5;
    //punkt poczatku ulicy
    private Point start;
    //punkt konca ulicy
    private Point end;
    //do narysowania lini na panelu
    private Line line;
    //kierunek danej ulicy
    private Direction direction;
    //lista kolejkujaca samochody
    private List<Car> cars;
    //kolor swiatla na danej ulicy
    private Color lightColor = Color.GREEN;
    // ilosc miejsc w liscie kolejkujacej
    private int numberOfPositions;
    // dlugosc ulicy
    private double lenght;
    //dlugosc jednej komorki w liscie kolejkujacej
    private Integer celllenght = 10;
    // licznik samochodow ktore przejechaly ulica do statystyk
    private Integer counter = 0;


    Street(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.line = new Line(start.getX(), start.getY(), end.getX(), end.getY());
        this.direction = new Direction(this.start, this.end);

        int y = Math.abs(start.getY() - end.getY());
        int x = Math.abs(start.getX() - end.getX());
        lenght = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

        numberOfPositions = (int)(lenght/celllenght);

        cars = new ArrayList<>(numberOfPositions);

        for( int i = 0; i < numberOfPositions; i++) {
            cars.add(null);
        }
    }

    //punkt ktory odpowiada indeksowi w liscie kolejkujacej
    public Point getPointOfPosition(int index) {
        int x = (int)(index * direction.getX() * celllenght + start.getX());
        int y = (int)(index * direction.getY() * celllenght + start.getY());
        return new Point(x,y);
    }

    public int getNumberOfPositions() {
        return numberOfPositions;
    }

    public List<Car> getCars()    {
        return cars;
    }

    // czy swiatlo jest zielone?
    public boolean isGreen() {
        return this.lightColor == Color.GREEN;
    }

    //zmiana swiatla
    public void changeLight(Color color) {
        this.lightColor = color;
    }

    public Street getLeft() {
        return left;
    }

    public void setLeft(Street left) {
        this.left = left;
    }

    public Street getRight() {
        return right;
    }

    public void setRight(Street right) {
        this.right = right;
    }

    public Street getStraight() {
        return straight;
    }

    public void setStraight(Street straight) {
        this.straight = straight;
    }

    public Integer getSpeedLimit() {
        return speedLimit;
    }

    public Point getStart() {
        return start;
    }

    public Line getLine() {
        return line;
    }

    public Direction getDirection() {
        return direction;
    }

    public void incrementCounter() {
        this.counter++;
    }

    public Integer getCounter() {
        return counter;
    }
}
