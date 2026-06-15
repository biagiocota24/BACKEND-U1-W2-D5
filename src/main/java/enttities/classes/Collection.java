package enttities.classes;

import enums.Piattaforme;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Collection {
    private Set<Gioco> listaGiochi;

    public Collection(Set<Gioco> listaGiochi) {
        this.listaGiochi = listaGiochi;
    }

    public Set<Gioco> getListaGiochi() {
        return listaGiochi;
    }


    // PER AGGIUNGERE UN GIOCO (CONTROLLO ANCHE SE E UN SET E NON ACCETTA DUPLICATI , PERO IL GAMEID VIENE CREATO SEMPRE DIVERSO ALLA CREAZIONE DEL GIOCO E LO AGGIUNGEREBBE COMUNQUE )
    public void addToCollection(Gioco gioco) {
        if (this.listaGiochi.stream().anyMatch(giocoGiaInlista -> giocoGiaInlista.getTitle().toLowerCase().equals(gioco.getTitle().toLowerCase()))) {
            System.out.println("Gioco gia presente in lista !");
        } else {
            this.listaGiochi.add(gioco);
        }
    }

    // TROVA UN SINGOLO GIOCO CON ID CORRISPONDENTE
    public Gioco cercaPerId(long idToSearch) {
        return listaGiochi.stream().filter(gioco -> gioco.getGameId() == idToSearch).findFirst().orElse(null);
    }

    // TROVA UNA LISTA DI GIOCHI CON PREZZO INFERIORE A QUELLO INSERITO
    public List<Gioco> filtraPerPrezzo(double prezzo) {
        List<Gioco> giochiFiltrati = this.listaGiochi.stream().filter(gioco -> gioco.getPrice() <= prezzo).toList();
        if (giochiFiltrati.isEmpty()) {
            System.out.println("Nessun gioco disponibile sotto questo prezzo");
        }
        return giochiFiltrati;
    }

    // RICERCA GIOCHI PER NUMERO DI GIOCATORI
    public List<Gioco> cercaPerNumGiocatori(int numGiocatori) {
        List<Gioco> giochiFiltrati = listaGiochi.stream().filter(gioco -> {
            if (gioco instanceof GiocoDaTavola) {
                return ((GiocoDaTavola) gioco).getNumGiocatori() == numGiocatori;
            }
            return false;
        }).toList();
        if (giochiFiltrati.isEmpty()) {
            System.out.println("Nessun gioco corrispondente !");
        }
        return giochiFiltrati;
    }

    //  RIMUOVE TRAMITE GAMEID
    public void removeWithGameId(long gameId) {
        boolean hoRimosso = this.listaGiochi.removeIf(gioco -> gioco.getGameId() == gameId);
        if (!hoRimosso) System.out.println("Nessun gioco con id corrispondente !");
    }

    // AGGIORNARE UN ELEMENTO ESISTENTE

    public void customGame(long gameId) {
        Scanner scanner = new Scanner(System.in);
        Gioco gameToCustom = cercaPerId(gameId);
        //
        if (gameToCustom != null) {
            String nuovoTitolo;
            do {
                System.out.println("Imposta il nuovo nome ");
                nuovoTitolo = scanner.nextLine();
                if (nuovoTitolo.isEmpty()) System.err.println("Il titolo non puo essere vuoto !");
            } while (nuovoTitolo.isEmpty());
            gameToCustom.setTitle(nuovoTitolo);
            //
            boolean prezzoValido = false;
            double nuovoPrezzo = 0;
            do {
                System.out.println("Imposta il nuovo prezzo ");
                try {
                    nuovoPrezzo = Double.parseDouble(scanner.nextLine());
                    gameToCustom.setPrice(nuovoPrezzo);
                    prezzoValido = true;
                } catch (NumberFormatException e) {
                    System.err.println("Prezzo non valido !");
                }
            } while (!prezzoValido);

            if (gameToCustom instanceof Videogioco) {

                Piattaforme piattaforma = null;
                boolean piattaformaValida = false;
                do {
                    System.out.println("Imposta la piattaforma ");
                    try {
                        piattaforma = Piattaforme.valueOf(scanner.nextLine().toUpperCase());
                        ((Videogioco) gameToCustom).setPiattaforma(piattaforma);
                        piattaformaValida = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Piattaforma non disponibile !");
                    }
                } while (!piattaformaValida);

                int nuovaDurata = 0;
                boolean durataValida = false;
                do {
                    System.out.println("Imposta la durata del gioco");
                    try {
                        nuovaDurata = Integer.parseInt(scanner.nextLine());
                        ((Videogioco) gameToCustom).setDurataGioco(nuovaDurata);
                        durataValida = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Durata non valida , inserisci un numero");
                    }
                } while (!durataValida);
            }

            if (gameToCustom instanceof GiocoDaTavola) {

                boolean numGiocValido = false;
                int nuovoNumeroGioc = 0;
                do {
                    System.out.println("Inserisci un numero di giocatori valido (min.2 - max.10)");
                    try {
                        nuovoNumeroGioc = Integer.parseInt(scanner.nextLine());
                        ((GiocoDaTavola) gameToCustom).setNumGiocatori(nuovoNumeroGioc);
                        numGiocValido = true;
                    } catch (NumberFormatException e) {
                        System.err.println("numero giocatori non valido !");
                    }

                } while (!numGiocValido);


                int nuovaDurata = 0;
                boolean durataValida = false;
                do {
                    System.out.println("inserisci la nuova durata in minuti");
                    try {
                        nuovaDurata = Integer.parseInt(scanner.nextLine());
                        ((GiocoDaTavola) gameToCustom).setMinutiDurataMedia(nuovaDurata);
                        durataValida = true;
                    } catch (NumberFormatException e) {
                        System.err.println("Durata non valida !");
                    }
                } while (!durataValida);
            }

            System.out.println("OK --- Gioco aggiornato");
        } else {
            System.out.println("Nessun gioco corrispondente a questo id !");
        }
    }

    public void stampaStatistiche() {
        System.out.println("Giochi presenti in lista : " + listaGiochi.size());
        int nVideoGiochi = listaGiochi.stream().filter(gioco -> gioco instanceof Videogioco).toList().size();
        System.out.println("Videogiochi in lista : " + nVideoGiochi);
        int nGiochiDatavola = listaGiochi.stream().filter(gioco -> gioco instanceof GiocoDaTavola).toList().size();
        System.out.println("Gochi da tavolo in lista : " + nGiochiDatavola);
        Gioco giocoPiuCostoso = listaGiochi.stream().max(Comparator.comparingDouble(gioco -> gioco.getPrice())).orElse(null);
        System.out.println("Gioco piu costoso : " + giocoPiuCostoso.getTitle() + " " + giocoPiuCostoso.getPrice() + "€");
        double prezzoMedio = listaGiochi.stream().mapToDouble(gioco -> gioco.getPrice()).average().orElse(0);
        System.out.println("Perzzo medio dei giochi : " + prezzoMedio + "€");
    }

    @Override
    public String toString() {
        return "Collection{" +
                "listaGiochi=" + listaGiochi +
                '}';
    }

}
