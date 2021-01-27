import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ZapisNaDysk implements ZapisDane, ZapisStatystyka {
    String dane = "";
    String statystyka = "";


    @Override
    public String zapisDane(Dane a) {
        ArrayList<Punkt> listaPunktow = new ArrayList<Punkt>(a.getDane());

        for (Punkt p: listaPunktow) {
            this.dane += p.getX();
            if (listaPunktow.indexOf(p) != listaPunktow.size() - 1){
                this.dane += ", ";
            }
        }
        return dane;
    }

    @Override
    public String zapisStatystyka(float[] tabela) {

        for(int i = 0; i < tabela.length; i++){
            this.statystyka += tabela[i];
            if (i != tabela.length - 1){
                this.statystyka += ", ";
            }
        }
        return statystyka;
    }

    void zapis() throws IOException {
        FileWriter zapisPliku = new FileWriter("C:\\Users\\radek\\Desktop\\miejsce na pliki\\zapis.txt");
        PrintWriter zapisDoPliku = new PrintWriter(zapisPliku);
        zapisDoPliku.print("Poniżej zapisano dane Twojego szeregu: ");
        zapisDoPliku.printf("\n" + this.dane);
        zapisDoPliku.printf("\nOpis danych:\n[średnia, odchylenie, mediana, dominanta]");
        zapisDoPliku.printf("\n" + this.statystyka);
        zapisDoPliku.close();
    }
}
