import java.util.ArrayList;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Witaj w moim programie \n" +
                "Wybierz co chcesz zrobić:\n" +
                "1. Stwórz szereg wybranych punktów.\n" +
                "2. Stwórz szereg losowych punktów.\n" +
                "3. Stwórz szereg losowych punktów w wybranym zakresie\n");

        int wyborRodzajuSzeregu = myObj.nextInt();

        if (wyborRodzajuSzeregu < 1 || wyborRodzajuSzeregu > 3){
            System.out.println("Podano nieprawidłowy numer akcji.");
            System.exit(0);
        }

        System.out.println("Podaj długość szeregu");
        int dlugoscSzeregu = myObj.nextInt();

        Szereg nowySzereg = new Szereg();
        nowySzereg.szereg = Generator.generujSzereg(dlugoscSzeregu);

        switch (wyborRodzajuSzeregu){
            case 1:
                System.out.println("Podaj punkty (" + dlugoscSzeregu + "):");
                for(int i = 0; i < dlugoscSzeregu; i++){
                    System.out.println("Podaj liczbę: ");
                    int liczba = myObj.nextInt();
                    Punkt p = new Punkt(liczba);
                    nowySzereg.szereg.set(i, p);
                }
                System.out.println("Szereg punktów o długości: " + dlugoscSzeregu + " został stworzony.\n" +
                        "Oto wartości tych punktów:");
                nowySzereg.wypiszWartosciSzeregu();
                break;
            case 2:
                nowySzereg.szereg = Generator.generujSzeregLosowychPunktow(dlugoscSzeregu);

                System.out.println("Szereg losowych punktów o długości: " + dlugoscSzeregu + " został stworzony.\n" +
                        "Oto wartości tych punktów:");
                nowySzereg.wypiszWartosciSzeregu();
                break;
            case 3:
                System.out.println("Podaj dolny zakres:");
                int minWartosc = myObj.nextInt();

                System.out.println("Podaj górny zakres:");
                int maxWartosc = myObj.nextInt();

                nowySzereg.szereg = Generator.generujSzeregWZakresie(dlugoscSzeregu, minWartosc, maxWartosc);

                System.out.println("Szereg losowych punktów o długości: " + dlugoscSzeregu +
                        " i zakresie: " + minWartosc + ", " + maxWartosc + " został stworzony.\n" +
                        "Oto wartości tych punktów:");
                nowySzereg.wypiszWartosciSzeregu();
                break;
        }
        System.out.println("\nNazwij utworzony szereg (jednym wyrazem):");
        nowySzereg.setNazwaSzeregu(myObj.next()); //napraw żeby nextLine() działało
        System.out.println(nowySzereg.getNazwaSzeregu());



        double mediana = new Statystyka().mediana(nowySzereg);
        System.out.println(mediana);

//        System.out.println("Co chciałbyś zrobić ze swoim szeregiem?\n" +
//                "1. Mediana.\n" +
//                "2. Dominanta.\n" +
//                "3. Srednia.\n" +
//                "4. Odchylenie standardowe.\n" +
//                "5. Zapis na dysk.\n");
//
//        int wyborAkcji = myObj.nextInt();
//        switch (wyborAkcji){
//            case 1:
//                //Wypisz medianę szeregu
//                break;
//            case 2:
//                //Wypisz dominantę szeregu
//                break;
//            case 3:
//                //Wypisz średnią szeregu
//                break;
//            case 4:
//                //Wypisz odchylenie standardowe
//                break;
//            case 5:
//                //Zapisz na dysk
//                break;
//        }
    }
}