package sample;

import javafx.scene.shape.Circle;

public class Car {

    private Circle circle;
    private Integer currentSpeed;
    private Street street;

    void drive(){
        switch (street.getDirection()) {
            case NORTH:
                circle.setCenterY(circle.getCenterY() - currentSpeed);
                break;
            case EAST:
                circle.setCenterX(circle.getCenterX() + currentSpeed);
                break;
            case SOUTH:
                circle.setCenterY(circle.getCenterY() + currentSpeed);
                break;
            case WEST:
                circle.setCenterX(circle.getCenterX() - currentSpeed);
                break;
        }
    }

    public void driveRight(){
        switch (street.getDirection()) {
            case NORTH:
                circle.setCenterY(circle.getCenterY() - currentSpeed);
                if(circle.getCenterY() < street.getEnd().getY()){
                    circle.setCenterY(street.getEnd().getY());
                    if(street.getRight() == null){
                        currentSpeed = 0;
                        break;
                    }
                    street = street.getRight();
                }
                break;
            case EAST:
                circle.setCenterX(circle.getCenterX() + currentSpeed);
                if(circle.getCenterX() > street.getEnd().getX()){
                    circle.setCenterX(street.getEnd().getX());
                    if(street.getRight() == null){
                        currentSpeed = 0;
                        break;
                    }
                    street = street.getRight();
                }
                break;
            case SOUTH:
                circle.setCenterY(circle.getCenterY() + currentSpeed);
                if(circle.getCenterY() > street.getEnd().getY()){
                    circle.setCenterY(street.getEnd().getY());
                    if(street.getRight() == null){
                        currentSpeed = 0;
                        break;
                    }
                    street = street.getRight();
                }
                break;
            case WEST:
                circle.setCenterX(circle.getCenterX() - currentSpeed);
                if(circle.getCenterX() < street.getEnd().getX()){
                    circle.setCenterX(street.getEnd().getX());
                    if(street.getRight() == null){
                        currentSpeed = 0;
                        break;
                    }
                    street = street.getRight();
                }
                break;
        }
    }

    void driveLeft(){
        switch (street.getDirection()) {
            case NORTH:
                circle.setCenterY(circle.getCenterY() - currentSpeed);
                if(circle.getCenterY() < street.getEnd().getY()){
                    turnLeftIfYouCan();
                }
                break;
            case EAST:
                circle.setCenterX(circle.getCenterX() + currentSpeed);
                if(circle.getCenterX() > street.getEnd().getX()){
                    turnLeftIfYouCan();
                }
                break;
            case SOUTH:
                circle.setCenterY(circle.getCenterY() + currentSpeed);
                if(circle.getCenterY() > street.getEnd().getY()){
                    turnLeftIfYouCan();
                }
                break;
            case WEST:
                circle.setCenterX(circle.getCenterX() - currentSpeed);
                if(circle.getCenterX() < street.getEnd().getX()){
                    turnLeftIfYouCan();
                }
                break;
        }
    }

    private void turnLeftIfYouCan() {
        if (street.getLeft() == null) {
            currentSpeed = 0;
            return;
        }
        street = street.getLeft();
        circle.setCenterX(street.getStart().getX());
        circle.setCenterY(street.getStart().getY());
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
