package enttities;

import enttities.classes.Collection;
import enttities.classes.Gioco;
import enttities.classes.GiocoDaTavola;
import enttities.classes.Videogioco;
import enums.Generi;
import enums.Piattaforme;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // 5 VIDEOGIOCHI
        Videogioco videoGame1 = new Videogioco("GTA 5", 70, Piattaforme.PS5, 60, Generi.azione);
        Videogioco videoGame2 = new Videogioco("The Last of Us", 65, Piattaforme.PS5, 50, Generi.azione);
        Videogioco videoGame3 = new Videogioco("FIFA 25", 60, Piattaforme.PS5, 40, Generi.sport);
        Videogioco videoGame4 = new Videogioco("Elden Ring", 75, Piattaforme.PS5, 55, Generi.strategia);
        Videogioco videoGame5 = new Videogioco("Call of Duty", 80, Piattaforme.PS5, 70, Generi.combattimento);

        // 5 GIOCHI DA TAVOLA
        GiocoDaTavola giocoT1 = new GiocoDaTavola("Tombola", 10, 8, 30);
        GiocoDaTavola giocoT2 = new GiocoDaTavola("Monopoly", 25, 4, 120);
        GiocoDaTavola giocoT3 = new GiocoDaTavola("Scarabeo", 20, 4, 60);
        GiocoDaTavola giocoT4 = new GiocoDaTavola("Risiko", 35, 6, 180);
        GiocoDaTavola giocoT5 = new GiocoDaTavola("Cluedo", 22, 6, 90);

        Set<Gioco> lista = new HashSet<>();
        Collection listaGiochi = new Collection(lista);
        listaGiochi.addToCollection(videoGame1);
        listaGiochi.addToCollection(giocoT1);
        listaGiochi.addToCollection(videoGame2);
        listaGiochi.addToCollection(giocoT3);
        listaGiochi.addToCollection(videoGame5);
        listaGiochi.addToCollection(giocoT2);
        listaGiochi.addToCollection(videoGame3);
        listaGiochi.addToCollection(giocoT5);
        listaGiochi.addToCollection(giocoT4);
        listaGiochi.addToCollection(videoGame4);

//        listaGiochi.getListaGiochi().stream().forEach(gioco -> System.out.println(gioco));

//        System.out.println(listaGiochi.cercaPerId(3));

//        System.out.println(listaGiochi.filtraPerPrezzo(10));

//        System.out.println(listaGiochi.cercaPerNumGiocatori(6));

//        listaGiochi.removeWithGameId(4);

                listaGiochi.getListaGiochi().stream().forEach(gioco -> System.out.println(gioco));





    }
}
