package sample;


public class Simulation extends Thread {

    @Override
    public void run() {
        while(true) {
            //Model.getInstance().getCars().forEach(Car::driveRight);
            try {
                sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
