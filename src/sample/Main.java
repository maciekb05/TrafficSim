package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static java.lang.Thread.sleep;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello World");
        Pane root = new Pane();
        Controller controller = new Controller(root);
        controller.initializeModel();

        Model.getInstance().getStreets().forEach(st -> root.getChildren().add(st.getLine()));
        //model.cars.forEach(car -> root.getChildren().add(car.circle));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        Simulation sim = new Simulation();
        sim.start();

        while(true) {
            try {
                Thread.sleep(1000);
                Model.getInstance().getSpawningPlaces().forEach(SpawningPlace::spawnCars);
                Model.getInstance().getCars().forEach(car -> root.getChildren().add(car.getCircle()));

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
