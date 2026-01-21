package filippotimo.dao;

import filippotimo.entities.Evento;
import filippotimo.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventiDAO {
    // DAO (Data Access Object) è un Design Pattern. È una classe speciale che ci serve per interagire in maniera semplice con il DB.
    // Le operazioni normali come salvare o leggere dei record, richiedono l'uso dell'EntityManager con una certa complessità. Il DAO quindi
    // si occupa di nascondere questa complessità fornendo a chi ne avrà bisogno dei metodi semplici da usare

    // Innanzitutto dobbiamo avere qui nel DAO l'EntityManager per far si che il DAO possa fare tutte le operaioni
    // quindi creiamo l'attributo entityManager
    private EntityManager entityManager;

    // E qui creiamo il suo costruttore
    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {

        // step 1) Chiediamo all'entityManager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // step 2) Facciamo partire la transazione
        transaction.begin(); // (QUI INIZIA LA TRANSAZIONE)

        // step 3) Aggiungiamo il newEvento al PersistenceContext (in quanto esso è nuovo e non ancora MANAGED)
        // Lo si fa tramite il metodo .persist() dell'entityManager (qui l'oggetto non fa ancora parte del DB)
        entityManager.persist(newEvento);

        // step 4) Per far si che il nuovo oggetto entri nel DB dobbiamo fare il COMMIT
        transaction.commit(); // (QUI FINISCE LA TRANSAZIONE)

        // step 5 facoltativo) Facciamo un LOG (un messaggio in console) per vedere se il save è avvenuto correttamente
        System.out.println("L'evento con titolo = " + newEvento.getTitolo() + " è stato salvato correttamente");
    }

    public Evento findById(long eventoId) {
        Evento found = entityManager.find(Evento.class, eventoId); // Primo parametro = nome tabella / Secondo parametro = id da cercare
        if (found == null)
            throw new NotFoundException(eventoId); // Controllo se torna found e nel caso lancio un'eccezione custom
        return found;
    }

    public void findByIdAndDeleted(long eventoId) {
        // step 1) Cerco l'evento tramite Id nel DB
        Evento found = this.findById(eventoId); // Riutilizziamo il metodo .findById() di prima senza doverlo rifare

        // step 2) Chiediamo all'entityManager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // step 3) Facciamo partire la transazione
        transaction.begin(); // (QUI INIZIA LA TRANSAZIONE)

        // step 4) Rimuoviamo dal Persistence Context l'oggetto in questione tramite metodo .remove() dell'entityManager
        // Qui come nel metodo SAVE non è ancora stato rimosso dal DB, bensì è stato marchiato come "da rimuovere"
        entityManager.remove(found);

        // step 5) Per far si che il nuovo oggetto venga rimosso veramente dal DB dobbiamo fare il COMMIT
        transaction.commit(); // (QUI FINISCE LA TRANSAZIONE)

        // step 5 facoltativo) Facciamo un LOG (un messaggio in console) per vedere se l'oggetto è stato rimosso correttamente
        System.out.println("L'evento con id = " + eventoId + " è stato eliminato correttamente");
    }

}