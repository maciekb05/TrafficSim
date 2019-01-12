package sample;


import javafx.scene.paint.Color;

//symulacja swiatel drogowych
public class SimulateLights extends Thread {

    @Override
    public void run() {
        //główne ulice początkowo ustawiam na czerwone
        this.setLightForVerticalLeft(Color.RED);
        this.setLightForVerticalRightStraight(Color.RED);
        this.setLightForHorizontalLeft(Color.RED);
        this.setLightForHorizontalRightStraight(Color.RED);

        while(true) {

            try {
                this.setLightForVerticalRightStraight(Color.ORANGE);
                sleep(3000);
                this.setLightForVerticalRightStraight(Color.GREEN);
                sleep(8000);
                this.setLightForVerticalRightStraight(Color.ORANGE);
                sleep(3000);
                this.setLightForVerticalRightStraight(Color.RED);

                sleep(3000);
                this.setLightForVerticalLeft(Color.ORANGE);
                sleep(3000);
                this.setLightForVerticalLeft(Color.GREEN);
                sleep(8000);
                this.setLightForVerticalLeft(Color.ORANGE);
                sleep(3000);
                this.setLightForVerticalLeft(Color.RED);

                sleep(3000);
                this.setLightForHorizontalRightStraight(Color.ORANGE);
                sleep(3000);
                this.setLightForHorizontalRightStraight(Color.GREEN);
                sleep(8000);
                this.setLightForHorizontalRightStraight(Color.ORANGE);
                sleep(3000);
                this.setLightForHorizontalRightStraight(Color.RED);

                sleep(3000);
                this.setLightForHorizontalLeft(Color.ORANGE);
                sleep(3000);
                this.setLightForHorizontalLeft(Color.GREEN);
                sleep(8000);
                this.setLightForHorizontalLeft(Color.ORANGE);
                sleep(3000);
                this.setLightForHorizontalLeft(Color.RED);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //funkcja zmieniajaca kolor swiatel
    private void changeLight(Integer streetNr, Integer lightNr, Color color) {
        Model.getInstance().getStreets().get(streetNr).changeLight(color);
        Model.getInstance().getLights().get(lightNr).changeColor(color);
    }

    // funkcja zmieniajacakolor siatel na ulicach poziomych dla ulic jadacych prosto
    private void setLightForVerticalRightStraight(Color color) {
        this.changeLight(0,0, color);
        this.changeLight(1,1, color);
        this.changeLight(10,6, color);
        this.changeLight(11,7, color);
    }

    // funkcja zmieniajacakolor siatel na ulicach poziomych dla ulic skrecajacych w lewo
    private void setLightForVerticalLeft(Color color) {
        this.changeLight(2,2, color);
        this.changeLight(12,8, color);
    }

    // funkcja zmieniajacakolor siatel na ulicach pionowych dla ulic jadacych prosto
    private void setLightForHorizontalRightStraight(Color color) {
        this.changeLight(5,3, color);
        this.changeLight(6,4, color);
        this.changeLight(15,9, color);
        this.changeLight(16,10, color);
    }

    // funkcja zmieniajacakolor siatel na ulicach pionowych dla ulic skrecajacych w lewo
    private void setLightForHorizontalLeft(Color color) {
        this.changeLight(7,5, color);
        this.changeLight(17,11, color);
    }
}
