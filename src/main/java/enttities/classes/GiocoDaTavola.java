package enttities.classes;

public class GiocoDaTavola extends Gioco {

    private int numGiocatori;
    private int minutiDurataMedia;

    public GiocoDaTavola(String title, double price, int numGiocatori, int minutiDurataMedia) {
        super(title, price);
        this.numGiocatori = numGiocatori;
        this.minutiDurataMedia = minutiDurataMedia;
    }

    public void setNumGiocatori(int numGiocatori) {
        if (numGiocatori >= 2 && numGiocatori <= 10) {
            this.numGiocatori = numGiocatori;
        } else {
            System.out.println("Devi selezionare il numero in un range da 2 a 10 ! ");
        }
    }

    public int getNumGiocatori() {
        return numGiocatori;
    }

    public void setMinutiDurataMedia(int minutiDurataMedia) {
        this.minutiDurataMedia = minutiDurataMedia;
    }

    @Override
    public String toString() {
        return "GiocoDaTavola{" +
                "numGiocatori=" + numGiocatori +
                ", minutiDurataMedia=" + minutiDurataMedia +
                "} " + super.toString();
    }
}
