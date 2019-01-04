package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Light extends Circle {

    public Light() {
        this.setFill(Color.GREEN);
        this.setRadius(4.0);
    }

    public void changeColor(Color color) {
        this.setFill(color);
    }
}
