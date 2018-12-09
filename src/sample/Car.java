package sample;

import javafx.scene.shape.Circle;

import java.util.List;

public class Car implements Comparable<Car> {

    private int id;
    private static int numbersOfCars = 0;

    private Circle circle;
    private Integer currentSpeed;
    private int currentPosition;
    private Street street;

    void drive() {




        circle.setCenterX(circle.getCenterX() + currentSpeed * street.getDirection().getX());
        circle.setCenterY(circle.getCenterY() + currentSpeed * street.getDirection().getY());

        updateActualPosition();


    }

    void updateActualPosition(){
        int x =(int) (circle.getCenterX() - street.getStart().getX());
        double y =(int) (circle.getCenterY() - street.getStart().getY());
        int z =(int) Math.sqrt(Math.pow(x,2) + Math.pow(y,2))/10;

        street.getCars().set(currentPosition, null);
        if (z <= street.getNumberOfPositions() && currentPosition <= street.getNumberOfPositions()){
            street.getCars().set(currentPosition, null);
            street.getCars().add(z,this);
            this.currentPosition = z;
        }
//        System.out.println("Y= " + y + " X= " + x + " Z= " + z + " Street.numberOfPositions= " + street.getNumberOfPositions());
        System.out.println( "Y= " + y + " Z= " + z + "   POSITION: " + this.currentPosition);
    }

    public Street getStreet() {
        return street;
    }

    void setStreet(Street street) {
        this.street = street;
    }

    Car(Point center) {
        this.id = ++numbersOfCars;
        this.circle = new Circle(center.getX(), center.getY(), 3);
        this.currentSpeed = 0;
    }

    Circle getCircle() {
        return circle;
    }

    public int getId() {return id;}

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Integer getCurrentSpeed() {
        return currentSpeed;
    }

    void setCurrentSpeed(Integer currentSpeed) {
        this.currentSpeed = currentSpeed < street.getSpeedLimit() ? currentSpeed : street.getSpeedLimit();
    }

    public void setCurrentPosition(int position) {
        this.currentPosition = position;
    }

    @Override
    public int compareTo(Car o) {
        return this.getId() > o.getId() ? +1 : this.getId() < o.getId() ? -1 : 0;
    }
}
