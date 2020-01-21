import java.util.Random;

class Punkt {
    private int x;

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    private int stworzLosowyXWZakresie(int min, int max) throws ZakresPunktowException{
        if(min > max){
            ZakresPunktowException zpe = new ZakresPunktowException();
            zpe.setBlad("Wartość maksymalna zakresu nie może być mniejsza od wartości minimalnej!");
            throw zpe;
        } else {
            Random r = new Random();
            this.setX(r.ints(min, (max + 1)).findFirst().getAsInt());
            return this.getX();
        }
    }

    int stworzLosowyX(){
        Random random = new Random();
        this.setX(random.ints().findFirst().getAsInt());
        return this.getX();
    }

    Punkt(int value){
        setX(value);
    }

    Punkt(){}

    Punkt(int minimumValue, int maximumValue) {
        try {
            this.stworzLosowyXWZakresie(minimumValue, maximumValue);
        }
        catch(ZakresPunktowException e){
            System.out.println("Operacja przerwana bo " + e.getBlad());
            System.exit(0);
        }
    }
}