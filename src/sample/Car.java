package sample;

import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Car implements Comparable<Car> {

    private int id;
    private static int numbersOfCars = 0;

    private Circle circle;
    private Integer currentSpeed;
    private int currentPosition;
    private int distanceFromNextCar;
    private int nextCarSpeed;
    private Street street;
    private Street nextstreet = null;

    void drive() {
        //System.out.println("Car: poz= "+ this.currentPosition + " speed= "+ this.currentSpeed + " NextCar dis=" + this.distanceFromNextCar + " speed= " + this.nextCarSpeed);
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

    void updateDistanceAndSpeedFromNextCar() {
        for (int i = this.currentPosition + 1; i < street.getNumberOfPositions(); i++){
            if (street.getCars().get(i) != null){
                this.distanceFromNextCar = i - this.currentPosition - 1;
                this.nextCarSpeed = street.getCars().get(i).getCurrentSpeed();
                break;
            } else if (street.getNumberOfPositions() - 1 == i){
                this.distanceFromNextCar = i - this.currentPosition - 1;
                this.nextCarSpeed = 0;
                break;
            }
        }

        if (street.isGreen() && this.nextstreet != null) {
            for (int i = 0; i < nextstreet.getNumberOfPositions(); i++){
                if (nextstreet.getCars().get(i) != null){
                    this.distanceFromNextCar += i;
                    this.nextCarSpeed = nextstreet.getCars().get(i).getCurrentSpeed();
                    break;
                } else if (nextstreet.getNumberOfPositions() - 1 == i){
                    this.distanceFromNextCar += i;
                    this.nextCarSpeed = 0;
                    break;
                }
            }
        }

    }

    void updateActualPosition(){
        int x =(int) (circle.getCenterX() - street.getStart().getX());
        int y =(int) (circle.getCenterY() - street.getStart().getY());
        int z =(int) Math.sqrt(Math.pow(x,2) + Math.pow(y,2))/10;

        if (z < street.getNumberOfPositions() && this.currentPosition < street.getNumberOfPositions()){
            street.getCars().set(currentPosition, null);
            street.getCars().set(z,this);
            this.currentPosition = z;
        } else if (z == street.getNumberOfPositions()){
            this.street.getCars().set(this.currentPosition,null);
            this.street = this.nextstreet;
            this.nextstreet = null;
            this.currentPosition = 0;
            this.street.getCars().set(this.currentPosition, this);
            this.circle.setCenterX(this.street.getStart().getX());
            this.circle.setCenterY(this.street.getStart().getY());

        }
//        System.out.println( "Y= " + y + " Z= " + z + "   POSITION: " + this.currentPosition);
    }

    void chooseNextStreet() {
        if (nextstreet == null){
            List<Street> st = new ArrayList<>();
            if(street.getLeft() != null) st.add(street.getLeft());
            if(street.getStraight() != null) st.add(street.getStraight());
            if(street.getRight() != null) st.add(street.getRight());

            if (st.size() == 0){
                st.add(Model.getInstance().getStreets().get(0));
                st.add(Model.getInstance().getStreets().get(1));
                st.add(Model.getInstance().getStreets().get(2));

                st.add(Model.getInstance().getStreets().get(5));
                st.add(Model.getInstance().getStreets().get(6));
                st.add(Model.getInstance().getStreets().get(7));

                st.add(Model.getInstance().getStreets().get(10));
                st.add(Model.getInstance().getStreets().get(11));
                st.add(Model.getInstance().getStreets().get(12));

                st.add(Model.getInstance().getStreets().get(15));
                st.add(Model.getInstance().getStreets().get(16));
                st.add(Model.getInstance().getStreets().get(17));
            }

            Random rand = new Random();
            this.nextstreet = st.get(rand.nextInt(st.size()));
        }
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
