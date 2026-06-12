package enttities.classes;

import java.util.List;
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
        Gioco gameToCustom = cercaPerId(gameId);
        if (gameToCustom != null) {
            if (gameToCustom instanceof Videogioco){}
            if (gameToCustom instanceof GiocoDaTavola){}
        } else {
            System.out.println("Nessun gioco corrispondente a questo id !");
        }
    }

    @Override
    public String toString() {
        return "Collection{" +
                "listaGiochi=" + listaGiochi +
                '}';
    }
}
