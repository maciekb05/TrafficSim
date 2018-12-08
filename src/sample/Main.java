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
        Model.getInstance().getSpawningPlaces().forEach(sp -> sp.spawnCars(20));
        Model.getInstance().getCars().forEach(car -> root.getChildren().add(car.getCircle()));
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
        Simulation sim = new Simulation();
        sim.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


/*todo:
 światła drogowe***   Aga
 wykrywanie skręcania **  Aga
 przyspieszanie skręcanie model Nagela    Konrad
 stop przed koncem ulicy lub wybranie kolejnej Konrad
 Update położenia samochodow na ulicy (liscie) Maciek

*/
