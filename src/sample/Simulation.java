package sample;


public class Simulation extends Thread {
    private Integer a=0;

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

            if (a % 10 == 0){
                a = 0;
                Model.printStatistic(Model.getInstance().getStreets());
            }
            this.a++;
            //System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX");
            try {
                sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
