package sample;


public class Simulation extends Thread {

    @Override
    public void run() {
        while(true) {
            Model.getInstance().getCars().forEach(Car::chooseNextStreet);
            Model.getInstance().getCars().forEach(Car::updateDistanceAndSpeedFromNextCar);
            Model.getInstance().getCars().forEach(Car::setTheSpeedDependingOnTheSpeedAndDistanceOfTheNextCar);
            Model.getInstance().getCars().forEach(Car::decreaseSpeedRandomly);
            Model.getInstance().getCars().forEach(Car::updateDistanceAndSpeedFromNextCar);
            Model.getInstance().getCars().forEach(Car::setTheSpeedDependingOnTheSpeedAndDistanceOfTheNextCar2);
            Model.getInstance().getCars().forEach(Car::drive);
            Model.getInstance().getCars().forEach(Car::updateActualPosition);
            //System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX");
            try {
                sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
