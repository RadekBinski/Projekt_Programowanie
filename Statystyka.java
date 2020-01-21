import java.util.ArrayList;
import java.util.Collections;

public class Statystyka {

    /*
    mediana(dane a)
    dominanta(dane a)
    średnia(dane a)
    odchylenie(dane a)

     float[4]opisDanych;
     */

    double mediana(Dane a) {
//        Collections.sort(a.getDane());
//        ArrayList dane = a.getDane();
        double mediana;
        ArrayList<Punkt> szereg = a.getDane();
        ArrayList<Integer> dane = new ArrayList<>();

        for (int i = 0; i > szereg.size(); i++){
            dane.set(i, szereg.get(i).getX());
        }

        Collections.sort(dane);
        if (dane.size() % 2 == 0) {
            mediana = ((double) dane.get(dane.size() / 2)) + (double) dane.get(dane.size() / 2 - 1) / 2;
        } else {
            mediana = (double) dane.get(dane.size() / 2 - 1);
        }
        return mediana;
    }
//    int dominanta(Dane a){
//
//    }
//
//    double srednia(Dane a){
//
//    }
//
//    double odchylenie(Dane a){
//
//    }
}