package enttities;

import enttities.classes.Collection;
import enttities.classes.Gioco;
import enttities.classes.GiocoDaTavola;
import enttities.classes.Videogioco;
import enums.Generi;
import enums.Piattaforme;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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
        listaGiochi.addToCollection(giocoT1);
        listaGiochi.addToCollection(giocoT2);
        listaGiochi.addToCollection(giocoT3);
        listaGiochi.addToCollection(giocoT4);
        listaGiochi.addToCollection(giocoT5);
        listaGiochi.addToCollection(videoGame1);
        listaGiochi.addToCollection(videoGame2);
        listaGiochi.addToCollection(videoGame3);
        listaGiochi.addToCollection(videoGame4);
        listaGiochi.addToCollection(videoGame5);

//        listaGiochi.getListaGiochi().stream().forEach(gioco -> System.out.println(gioco));

//        System.out.println(listaGiochi.cercaPerId(3));

//        System.out.println(listaGiochi.filtraPerPrezzo(10));

//        System.out.println(listaGiochi.cercaPerNumGiocatori(6));

//        listaGiochi.removeWithGameId(4);
//
//        listaGiochi.getListaGiochi().stream().forEach(gioco -> System.out.println(gioco));
//
//        listaGiochi.customGame(2);
//
//        listaGiochi.getListaGiochi().stream().forEach(gioco -> System.out.println(gioco));

//        listaGiochi.stampaStatistiche();

//        Gioco giocoPiuCostoso = listaGiochi.getListaGiochi().stream().max(Comparator.comparingDouble(gioco -> gioco.getPrice())).orElse(null);
//        System.out.println(giocoPiuCostoso);


        System.out.println("---------------TUTTI I GIOCHI-----------------");
        listaGiochi.getListaGiochi().forEach(gioco -> System.out.println(gioco));

        System.out.println("--------------- AZIONI ---------------- ");

        boolean azioneValida = false;
        int azione = -1;
        while (azione != 0) {

            do {
                System.out.println("Quale Azione vuoi eseguire ?");
                System.out.println("(1)AGGIUNGI | (2)RICERCA CON ID | (3)FILTRA PER PREZZO | (4)FILTRA PER NUMERO | (5)RIMUOVERE ELEMENTO CON ID | (6) AGGIORNAENTO ELEMENTO TRAMITE ID | (7)STAMPA DELLA STATISTICHE DELLA COLLEZIONE");
                System.out.println("Oppure inserisci 0 per uscire");
                try {
                    azione = Integer.parseInt(scanner.nextLine());
                    if (azione >= 0 && azione <= 7) {
                        azioneValida = true;
                    } else {
                        System.out.println("Inserisci un azione valida !");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Azione non valida !");
                }
            } while (!azioneValida);


            switch (azione) {
                case 0 -> {
                    break;
                }
                case 1 -> {
                    int tipo = 0;
                    boolean tipoValido = false;
                    do {
                        try {
                            System.out.println("Vuoi aggiungere (1)Videogioco o (2)Gioco da tavolo ?");
                            tipo = Integer.parseInt(scanner.nextLine());
                            if (tipo == 1 || tipo == 2) tipoValido = true;
                        } catch (NumberFormatException e) {
                            System.err.println("Tipo gioco non disponibile");
                        }
                    } while (!tipoValido);
                    System.out.println("Insersci il titolo");
                    String title = scanner.nextLine();
                    System.out.println("Inserisci il prezzo");
                    double price = Double.parseDouble(scanner.nextLine());
                    switch (tipo) {
                        case 1 -> {
                            System.out.println("Insersci la piattaforma (PS4 , PS5 , XBOX_ONE , XBOX_SERIE_X , PC)");
                            Piattaforme piattaforma = Piattaforme.valueOf(scanner.nextLine());
                            System.out.println("Inserisci la durata del gioco in ore");
                            int durata = Integer.parseInt(scanner.nextLine());
                            System.out.println("Insersci il genere (guerra , azione , sport , strategia , combattimento , crime)");
                            Generi genere = Generi.valueOf(scanner.nextLine());
                            Videogioco newVideoGame = new Videogioco(title, price, piattaforma, durata, genere);
                            listaGiochi.addToCollection(newVideoGame);
                            System.out.println("Gioco aggiunto");
                        }
                        case 2 -> {
                            System.out.println("Inserisci il numero massimo di giocatori da 2  a 10");
                            int numGiocatori = Integer.parseInt(scanner.nextLine());
                            System.out.println("Insersci la durata media in minuti ");
                            int minutiDurata = Integer.parseInt(scanner.nextLine());
                            GiocoDaTavola newGame = new GiocoDaTavola(title, price, numGiocatori, minutiDurata);
                            listaGiochi.addToCollection(newGame);
                            System.out.println("Gioco aggiunto");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Insersci il gameId ");
                    long gameId = Long.parseLong(scanner.nextLine());
                    Gioco giocoCercato = listaGiochi.cercaPerId(gameId);
                    if (giocoCercato != null) System.out.println("Trovato : " + giocoCercato);
                    else System.out.println("nessun gioco corrispondente all'Id !");
                }
                case 3 -> {
                    System.out.println("Inserisci il prezzo massimo ");
                    double maxPrice = Double.parseDouble(scanner.nextLine());
                    List<Gioco> listaFiltrata = listaGiochi.filtraPerPrezzo(maxPrice);
                    System.out.println("Ecco la lista filtrata :");
                    listaFiltrata.forEach(gioco -> System.out.println(gioco));
                }
                case 4 -> {
                    System.out.println("Inserisci il numero di giocatori desiderato ");
                    int numGiocatori = Integer.parseInt(scanner.nextLine());
                    List<Gioco> listaFiltrata = listaGiochi.cercaPerNumGiocatori(numGiocatori);
                    System.out.println("Ecco la lista filtrata :");
                    listaFiltrata.forEach(gioco -> System.out.println(gioco));
                }
                case 5 -> {
                    System.out.println("Inserisci il codice id del gioco che vuoi rimuovere");
                    long id = Long.parseLong(scanner.nextLine());
                    Gioco giocoRimosso = listaGiochi.cercaPerId(id); // ✅ prima cerca
                    if (giocoRimosso != null) {
                        listaGiochi.removeWithGameId(id);             // poi rimuovi
                        System.out.println("Gioco " + giocoRimosso.getTitle() + " rimosso");
                    } else {
                        System.out.println("Nessun gioco con questo id!");
                    }
                }
                case 6 -> {
                    System.out.println("Inserisci il codice id del gioco che vuoi modificare ");
                    long id = Long.parseLong(scanner.nextLine());
                    listaGiochi.customGame(id);
                }
                case 7 -> listaGiochi.stampaStatistiche();
            }
        }


    }
}

