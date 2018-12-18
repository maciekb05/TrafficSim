package sample;


import java.util.List;

public class SimulateLights extends Thread {
    //lista głównych ulic
    private List list = List.of(Model.getInstance().getStreets().get(0),
                        Model.getInstance().getStreets().get(1),
                        Model.getInstance().getStreets().get(10),
                        Model.getInstance().getStreets().get(11),
                        Model.getInstance().getStreets().get(2),
                        Model.getInstance().getStreets().get(12),
                        Model.getInstance().getStreets().get(5),
                        Model.getInstance().getStreets().get(6),
                        Model.getInstance().getStreets().get(15),
                        Model.getInstance().getStreets().get(16),
                        Model.getInstance().getStreets().get(7),
                        Model.getInstance().getStreets().get(17));

    @Override
    public void run() {
        //główne ulice początkowo ustawiam na czerwone
        Model.getInstance().getStreets().stream().filter(street -> list.contains(street)).forEach(Street::toggleLight);
        while(true) {
            System.out.println("Next tick");
            Model.getInstance().getStreets().forEach(str -> System.out.println("Ulica nr." + Model.getInstance().getStreets().indexOf(str) + " ma " + str.whatLight()));
            //na wprost i w prawo mają zielone
            Model.getInstance().getStreets().get(0).toggleLight();
            Model.getInstance().getStreets().get(1).toggleLight();
            Model.getInstance().getStreets().get(10).toggleLight();
            Model.getInstance().getStreets().get(11).toggleLight();
            Model.getInstance().getStreets().forEach(str -> System.out.println("Ulica nr." + Model.getInstance().getStreets().indexOf(str) + " ma " + str.whatLight()));
            try {
                sleep(11000);
                //na wprost i w prawo mają czerwone
                Model.getInstance().getStreets().get(0).toggleLight();
                Model.getInstance().getStreets().get(1).toggleLight();
                Model.getInstance().getStreets().get(10).toggleLight();
                Model.getInstance().getStreets().get(11).toggleLight();
                sleep(11000);
                //w lewo mają zielone
                Model.getInstance().getStreets().get(2).toggleLight();
                Model.getInstance().getStreets().get(12).toggleLight();
                Model.getInstance().getStreets().forEach(str -> System.out.println("Ulica nr." + Model.getInstance().getStreets().indexOf(str) + " ma " + str.whatLight()));
                sleep(11000);
                //w lewo mają czerwone
                Model.getInstance().getStreets().get(2).toggleLight();
                Model.getInstance().getStreets().get(12).toggleLight();
                sleep(11000);
                //2-na wprost i w prawo mają zielone
                Model.getInstance().getStreets().get(5).toggleLight();
                Model.getInstance().getStreets().get(6).toggleLight();
                Model.getInstance().getStreets().get(15).toggleLight();
                Model.getInstance().getStreets().get(16).toggleLight();
                Model.getInstance().getStreets().forEach(str -> System.out.println("Ulica nr." + Model.getInstance().getStreets().indexOf(str) + " ma " + str.whatLight()));
                sleep(11000);
                //2-na wprost i w prawo mają czerwone
                Model.getInstance().getStreets().get(5).toggleLight();
                Model.getInstance().getStreets().get(6).toggleLight();
                Model.getInstance().getStreets().get(15).toggleLight();
                Model.getInstance().getStreets().get(16).toggleLight();
                sleep(11000);
                //2-w lewo mają zielone
                Model.getInstance().getStreets().get(7).toggleLight();
                Model.getInstance().getStreets().get(17).toggleLight();
                Model.getInstance().getStreets().forEach(str -> System.out.println("Ulica nr." + Model.getInstance().getStreets().indexOf(str) + " ma " + str.whatLight()));   sleep(11000);
                //2-w lewo mają czerwone
                Model.getInstance().getStreets().get(7).toggleLight();
                Model.getInstance().getStreets().get(17).toggleLight();
                Model.getInstance().getStreets().forEach(str -> System.out.println("Ulica nr." + Model.getInstance().getStreets().indexOf(str) + " ma " + str.whatLight()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
