package filippotimo;

import filippotimo.dao.EventiDAO;
import filippotimo.entities.Evento;
import filippotimo.entities.tipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("giorno68pu");
    // Per connetterci al DB dobbiamo aggiungere al main un attributo statico di tipo EntityManagerFactory che sfrutterà
    // la Persistence Unit definita in persistence.xml per connettersi al DB (dobbiamo quindi passargli come parametro il nome della PU che in questo caso è "gestioneeventipu")

    // Se runnando la console esce scritto "Hello World!" allora la connsessione al server è andata a buon fine e posso committare e pushare la repo su github!!!

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager(); // Oggetto speciale che gestisce tutte le interazioni con il DB

        EventiDAO eventoDao = new EventiDAO(entityManager); // Creo un oggetto DAO in modo da richiamare poi i suoi metodi (ESEMPIO: evento.save, evento.findById, evento.findByIdAndDelete)
        // Tra parentesi gli passiamo l'entityManager perché il suo costruttore lo richiede

        Evento primoEvento = new Evento("Pupo in concerto", LocalDate.of(2025, 12, 6), "Imperdibile il concerto di pupo", tipoEvento.Pubblico, 5000);
        Evento secondoEvento = new Evento("Inter vs Milan", LocalDate.of(2025, 4, 13), "Il derby di Milano", tipoEvento.Pubblico, 75000);
        Evento terzoEvento = new Evento("Compleanno Pupo", LocalDate.of(2025, 11, 27), "Il compleanno più atteso dell'anno", tipoEvento.Privato, 300);
        Evento quartoEvento = new Evento("Compleanno Filippo", LocalDate.of(2025, 12, 6), "Il mio compleanno", tipoEvento.Privato, 30);
        Evento quintoEvento = new Evento("Compleanno Rita", LocalDate.of(2025, 7, 9), "Il compleanno di Rita", tipoEvento.Privato, 40);
//        System.out.println(primoEvento);
//        System.out.println(secondoEvento);
//        System.out.println(terzoEvento);
//        System.out.println(quartoEvento);
//        System.out.println(quintoEvento);

        // --------------------------------------------- SAVE ---------------------------------------------
        // ! ! ! Ogni volta che salvo un nuovo oggetto nel DB devo commentare o eliminare la riga del save perché sennò mi salverebbe
        // nuovamente gli oggetti nel DB creando dei ripetuti ogni volta che runno la console ! ! !
        eventoDao.save(primoEvento);
        eventoDao.save(secondoEvento);
        eventoDao.save(terzoEvento);
        eventoDao.save(quartoEvento);
        eventoDao.save(quintoEvento);

        // Best Practice. Quando finisco di utilizzare delle risorse come Scanner, EntityManager, EntityManagerFactory, ecc è sempre consigliato chiuderle
        // (nel nostro caso è irrilevante perché l'applicazione si avvia e poi si chiude rilasciando tutte le risorse automaticamente)
        entityManager.close();
        entityManagerFactory.close();
    }
}