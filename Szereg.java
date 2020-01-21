import java.util.ArrayList;
import java.util.Iterator;

public class Szereg implements Dane{
    private String nazwaSzeregu;
    ArrayList szereg;

    public String getNazwaSzeregu() {
        return nazwaSzeregu;
    }

    public void setNazwaSzeregu(String nazwaSzeregu) {
        this.nazwaSzeregu = nazwaSzeregu;
    }

    @Override
    public ArrayList getDane() {
//        ArrayList<Integer> dane = new ArrayList<>();
//        ArrayList<Punkt> lista = this.szereg;
//        for (int i = 0; i < lista.size(); i++){
//            dane.set(i, lista.get(i).getX());
//        }
//        return dane;
        return this.szereg;
    }

    public void wypiszWartosciSzeregu(){
        ArrayList<Punkt> szeregPunktow = this.szereg;
        Iterator<Punkt> iterator = szeregPunktow.iterator();

        if (iterator.hasNext()){
            System.out.print(iterator.next().getX());
        }

        while (iterator.hasNext()){
            System.out.print(", " + iterator.next().getX());
        }
        //wypisuje wszytkie X po przecinku
    }
}