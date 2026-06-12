package enttities.classes;

import enums.Generi;
import enums.Piattaforme;

public class Videogioco extends Gioco {
    private Piattaforme piattaforma;
    private int durataGioco;
    private Generi genere;

    public Videogioco(String title, double price, Piattaforme piattaforma, int durataGioco, Generi genere) {
        super(title, price);
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "piattaforma=" + piattaforma +
                ", durataGioco=" + durataGioco +
                ", genere=" + genere +
                "} " + super.toString();
    }
}
