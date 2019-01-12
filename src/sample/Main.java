package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static java.lang.Thread.sleep;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Hello World");
        Pane root = new Pane();
        Controller controller = new Controller(root);
        controller.initializeModel();

        //rysowanie modelu na panelu
        Model.getInstance().getStreets().forEach(st -> root.getChildren().add(st.getLine()));
        Model.getInstance().getSpawningPlaces().forEach(sp -> sp.spawnCars(12));
        Model.getInstance().getCars().forEach(car -> root.getChildren().add(car.getCircle()));
        Model.getInstance().getLights().forEach(light -> root.getChildren().add(light));

        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();

        //uruchamianie docelowych symulacji swiatel na skrzyzowaniu i samochodow
        SimulateLights simLights = new SimulateLights();
        simLights.start();
        Simulation sim = new Simulation();
        sim.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}