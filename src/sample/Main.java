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
        Model.getInstance().getSpawningPlaces().forEach(sp -> sp.spawnCars(500));
        Model.getInstance().getCars().forEach(car -> root.getChildren().add(car.getCircle()));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        Simulation sim = new Simulation();
        sim.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
