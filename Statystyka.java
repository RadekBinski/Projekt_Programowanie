import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Statystyka {

    static float[] opisDanych(Dane a){

        return new float[]{(float) srednia(a), (float) odchylenie(a),(float) mediana(a), dominanta(a)};
    }

    static double mediana(Dane a) {
        ArrayList<Punkt> dane = new ArrayList<Punkt>(a.getDane());
        dane.sort(Comparator.comparingInt(Punkt::getX));
        double dlugoscSzeregu = dane.size();
        double mediana;

        if (dlugoscSzeregu % 2 == 0) {
            mediana = (((double) dane.get(dane.size() / 2).getX() + (double) dane.get(dane.size() / 2 - 1).getX()) / 2);
        } else {
            mediana = dane.get(dane.size() / 2).getX();
        }
        return mediana;
    }

    static int dominanta(Dane a){
        ArrayList<Punkt> dane = new ArrayList<Punkt>(a.getDane());
        HashMap wartosciDanych = new HashMap();
        int maximumWystapien = 1;
        int dominanta = dane.get(0).getX();

        for (Punkt p : dane) {
            int wartoscAktualnegoIndexa = p.getX();
            if (wartosciDanych.containsKey(wartoscAktualnegoIndexa)) {
                int aktualnaLiczbaWystapien = (Integer) wartosciDanych.get(wartoscAktualnegoIndexa);
                aktualnaLiczbaWystapien++;
                wartosciDanych.put(wartoscAktualnegoIndexa, aktualnaLiczbaWystapien);

                if (aktualnaLiczbaWystapien >= maximumWystapien) {
                    dominanta = wartoscAktualnegoIndexa;
                    maximumWystapien = aktualnaLiczbaWystapien;
                }
            } else {
                wartosciDanych.put(p.getX(), 1);
            }
        }
        return dominanta;
        //aktualnie zwracam wartość, która wystąpiła w szeregu najwięcej razy
        //ale co jeśli dwie, lub więcej wartości wystąpią tak samo często np.: [1,2,1,2,3]?
    }

    static double srednia(Dane a){
        ArrayList<Punkt> dane = new ArrayList<Punkt>(a.getDane());
        double suma = 0;

        for (Punkt p: dane) {
            suma += p.getX();
        }
        return suma / dane.size();
    }

    static double odchylenie(Dane a){
        ArrayList<Punkt> dane = new ArrayList<Punkt>(a.getDane());
        double suma = 0;

        for (Punkt p: dane) {
            suma += Math.pow((double) p.getX() - srednia(a), 2);
        }
        return Math.sqrt(suma / dane.size());
    }
}