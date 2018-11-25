package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static java.lang.Thread.sleep;

public class Main extends Application {

    Controller controller;
    Model model;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello World");





        Pane root = new Pane();

        controller = new Controller(root);

        controller.createModel();
        model = controller.model;





        model.streets.forEach(st -> root.getChildren().add(st.getLine()));
        //model.cars.forEach(car -> root.getChildren().add(car.circle));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        Simulation sim = new Simulation(controller);
        sim.start();

        while(true) {
            try {
                Thread.sleep(1000);
                controller.spawnCars();
                model.cars.forEach(car -> root.getChildren().add(car.circle));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
