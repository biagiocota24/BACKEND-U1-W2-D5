package enttities.classes;

import enums.Generi;
import enums.Piattaforme;

import java.util.Scanner;

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

//    // COSTRUTTORE PER UTENTE
//    public Videogioco() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Insersci il titolo");
//        String title = scanner.nextLine();
//        System.out.println("Inserisci il prezzo");
//        double price = Double.parseDouble(scanner.nextLine());
//        super(title, price);
//        System.out.println("Insersci la piattaforma (PS4 , PS5 , XBOX_ONE , XBOX_SERIE_X , PC)");
//        Piattaforme piattaforma = Piattaforme.valueOf(scanner.nextLine());
//        this.piattaforma = piattaforma;
//        System.out.println("Inserisci la durata del gioco in ore");
//        this.durataGioco = Integer.parseInt(scanner.nextLine());
//        System.out.println("Insersci il genere (guerra , azione , sport , strategia , combattimento , crime)");
//        Generi genere = Generi.valueOf(scanner.nextLine());
//        this.genere = genere;
//    }

    public void setPiattaforma(Piattaforme piattaforma) {
        this.piattaforma = piattaforma;
    }

    public void setDurataGioco(int durataGioco) {
        this.durataGioco = durataGioco;
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
