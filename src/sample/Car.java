package sample;

import javafx.scene.shape.Circle;

public class Car {

    private Circle circle;
    private Integer currentSpeed;
    private Street street;

    void drive() {
        System.out.println("jade");
        circle.setCenterX(circle.getCenterX() + currentSpeed * street.getDirection().getX());
        circle.setCenterY(circle.getCenterY() + currentSpeed * street.getDirection().getY());
    }

    public Street getStreet() {
        return street;
    }

    void setStreet(Street street) {
        this.street = street;
    }

    Car(Point center) {
        this.circle = new Circle(center.getX(), center.getY(), 3);
        this.currentSpeed = 0;
    }

    Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Integer getCurrentSpeed() {
        return currentSpeed;
    }

    void setCurrentSpeed(Integer currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
