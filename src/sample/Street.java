package sample;

import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;


public class Street {
    private Street left = null;
    private Street right = null;
    private Street straight = null;
    private Integer speedLimit;
    private Point start;
    private Point end;
    private Line line;
    private Direction direction;
    private List<Car> cars;
    private boolean greenLight = true;
    private int numberOfPositions;
    private double lenght;

    Street(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.line = new Line(start.getX(), start.getY(), end.getX(), end.getY());
        this.direction = new Direction(this.start, this.end);

        int y = Math.abs(start.getY() - end.getY());
        int x = Math.abs(start.getX() - end.getX());
        lenght = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

        numberOfPositions = (int)(lenght/10);

        cars = new ArrayList<>(numberOfPositions);

        for( int i = 0; i < numberOfPositions; i++) {
            cars.add(null);
        }
    }

    public Point getPointOfPosition(int index) {
        int x = (int)(index * direction.getX() * 10 + start.getX());
        int y = (int)(index * direction.getY() * 10 + start.getY());
        return new Point(x,y,true);
    }

    public int getNumberOfPositions() {
        return numberOfPositions;
    }

    public void setNumberOfPositions(int numberOfPositions) {
        this.numberOfPositions = numberOfPositions;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void toggleLight() {
        greenLight = !greenLight;
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

    public void setSpeedLimit(Integer speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
