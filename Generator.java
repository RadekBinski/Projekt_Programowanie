import java.util.ArrayList;

public class Generator {

    private static boolean sprawdzLiczbePunktow(int liczbaSprawdzanychPunktow) throws LiczbaPunktowException {
        if (liczbaSprawdzanychPunktow <= 0) {
            LiczbaPunktowException lpe = new LiczbaPunktowException();
            lpe.setBlad("Liczba punktów jest mniejsza, bądź równa 0!");
            throw lpe;
        } else {
            return false;
        }
    }

    static ArrayList generujSzereg(int liczbaPunktow){
        try {
            sprawdzLiczbePunktow(liczbaPunktow);
        }
        catch (LiczbaPunktowException e){
            System.out.println("Operacja nieudana, bo: " + e.getBlad());
            System.exit(0);
        }
        ArrayList<Punkt> szeregPunktow = new ArrayList<>();

        while (szeregPunktow.size() < liczbaPunktow){
            Punkt p = new Punkt();
            szeregPunktow.add(p);
        }
        return szeregPunktow;
        //tworzy Arraylistę pustych Punktów
    }

    static ArrayList generujSzeregLosowychPunktow(int liczbaPunktow){
        ArrayList<Punkt> szeregPunktow = generujSzereg(liczbaPunktow);
        for (Punkt p: szeregPunktow) {
            p.stworzLosowyX();
        }
        return szeregPunktow;
        //tworzy Arraylistę Punktow z losowymi X-ami
    }

    static ArrayList generujSzeregWZakresie(int liczbaPunktow, int minimum, int maximum) {
        ArrayList szeregPunktow = generujSzereg(liczbaPunktow);
        for (int i = 0; i < szeregPunktow.size(); i++){
            Punkt p = new Punkt(minimum, maximum);
            szeregPunktow.set(i, p);
        }
        return szeregPunktow;
        //tworzy Arraylistę Punktów z losowymi X-ami w podanym zakresie
    }
}