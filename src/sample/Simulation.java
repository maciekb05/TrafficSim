package sample;

//symulacja samochodow
public class Simulation extends Thread {
    private Integer a=0;

    @Override
    public void run() {
        while(true) {
            // kazde auto wybiera kolejna ulice
            Model.getInstance().getCars().forEach(Car::chooseNextStreet);
            // kazde auto aktualizuje dystans i predkosc samochodu przed nim
            Model.getInstance().getCars().forEach(Car::updateDistanceAndSpeedFromNextCar);
            // kazde auto ustawia swoja predkosc na zalezna od poprzedniego kroku
            Model.getInstance().getCars().forEach(Car::setTheSpeedDependingOnTheSpeedAndDistanceOfTheNextCar);
            // niektore z samochodow zmniejszaja swoja z randomowych przyczyn
            Model.getInstance().getCars().forEach(Car::decreaseSpeedRandomly);
            // kazde auto aktualizuje dystans i predkosc samochodu przed nim
            Model.getInstance().getCars().forEach(Car::updateDistanceAndSpeedFromNextCar);
            // samochody reaguja na randowmowe zwalnianie samochodow poprzedajacych
            Model.getInstance().getCars().forEach(Car::setTheSpeedDependingOnTheSpeedAndDistanceOfTheNextCar2);
            // auta poruszaja sie
            Model.getInstance().getCars().forEach(Car::drive);
            // auta aktualizuja swoja pozycje
            Model.getInstance().getCars().forEach(Car::updateActualPosition);

            // co 10 tikow wypisujemy statystyki
            if (a % 10 == 0){
                a = 0;
                Model.printStatistic(Model.getInstance().getStreets());
            }
            this.a++;

            try {
                sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
