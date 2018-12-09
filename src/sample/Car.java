package sample;

import javafx.scene.shape.Circle;

import java.util.List;

public class Car implements Comparable<Car> {

    private int id;
    private static int numbersOfCars = 0;

    private Circle circle;
    private Integer currentSpeed;
    private int currentPosition;
    private int distanceFromNextCar;
    private int nextCarSpeed;
    private Street street;

    void drive() {


        System.out.println("Car: poz= "+ this.currentPosition + " speed= "+ this.currentSpeed + " NextCar dis=" + this.distanceFromNextCar + " speed= " + this.nextCarSpeed);

        circle.setCenterX(circle.getCenterX() + currentSpeed * street.getDirection().getX() * 0.2);
        circle.setCenterY(circle.getCenterY() + currentSpeed * street.getDirection().getY() * 0.2);

    }

    void setTheSpeedDependingOnTheSpeedAndDistanceOfTheNextCar() {
        if (this.nextCarSpeed + this.distanceFromNextCar > this.currentSpeed) {
            setCurrentSpeed(this.currentSpeed + 1);
        }
        else if (this.nextCarSpeed + this.distanceFromNextCar < this.currentSpeed){
            setCurrentSpeed(this.currentSpeed - 1);
        }
    }

    void updateDistanceFromNextCar() {
        this.distanceFromNextCar = street.getNumberOfPositions() - 1 - this.currentPosition;
        this.nextCarSpeed = 0;
        for (int i=this.currentPosition + 1; i<street.getNumberOfPositions();i++){
            if (street.getCars().get(i) != null){
                this.distanceFromNextCar = i - this.currentPosition -1;
                this.nextCarSpeed = street.getCars().get(i).getCurrentSpeed();
                break;
            }
        }
    }

    void updateActualPosition(){
        int x =(int) (circle.getCenterX() - street.getStart().getX());
        int y =(int) (circle.getCenterY() - street.getStart().getY());
        int z =(int) Math.sqrt(Math.pow(x,2) + Math.pow(y,2))/10;

        if (z < street.getNumberOfPositions() && currentPosition < street.getNumberOfPositions()){
            street.getCars().set(currentPosition, null);
            street.getCars().set(z,this);
            this.currentPosition = z;
        }
//        System.out.println("Y= " + y + " X= " + x + " Z= " + z + " Street.numberOfPositions= " + street.getNumberOfPositions());
//        System.out.println( "Y= " + y + " Z= " + z + "   POSITION: " + this.currentPosition);
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
        this.currentSpeed = currentSpeed > street.getSpeedLimit() ? street.getSpeedLimit() : currentSpeed < 0 ? 0 : currentSpeed;
    }

    public void setCurrentPosition(int position) {
        this.currentPosition = position;
    }

    private int getCurrentPosition() {
        return this.currentPosition;
    }

    @Override
    public int compareTo(Car o) {
        return this.getId() > o.getId() ? +1 : this.getId() < o.getId() ? -1 : 0;
    }
}
