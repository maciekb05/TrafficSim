package sample;


public class Simulation extends Thread {
    Controller controller;

    public Simulation(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        while(true) {
            controller.drive();
            try {
                sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
