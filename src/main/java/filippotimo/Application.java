package filippotimo;

import filippotimo.dao.EventiDAO;
import filippotimo.dao.LocationsDAO;
import filippotimo.dao.PartecipazioniDAO;
import filippotimo.dao.PersoneDAO;
import filippotimo.entities.Location;
import filippotimo.entities.Persona;
import filippotimo.entities.sesso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("giorno69pu");
    // Per connetterci al DB dobbiamo aggiungere al main un attributo statico di tipo EntityManagerFactory che sfrutterà
    // la Persistence Unit definita in persistence.xml per connettersi al DB (dobbiamo quindi passargli come parametro il nome della PU che in questo caso è "gestioneeventipu")

    // Se runnando la console esce scritto "Hello World!" allora la connsessione al server è andata a buon fine e posso committare e pushare la repo su github!!!

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager(); // Oggetto speciale che gestisce tutte le interazioni con il DB

        EventiDAO eventoDao = new EventiDAO(entityManager); // Creo un oggetto DAO in modo da richiamare poi i suoi metodi (ESEMPIO: evento.save, evento.findById, evento.findByIdAndDelete)
        // Tra parentesi gli passiamo l'entityManager perché il suo costruttore lo richiede

        LocationsDAO locationDao = new LocationsDAO(entityManager);
        PartecipazioniDAO partecipazioneDao = new PartecipazioniDAO(entityManager);
        PersoneDAO personeDao = new PersoneDAO(entityManager);

//        Evento primoEvento = new Evento("Pupo in concerto", LocalDate.of(2025, 12, 6), "Imperdibile il concerto di pupo", tipoEvento.Pubblico, 5000);
//        Evento secondoEvento = new Evento("Inter vs Milan", LocalDate.of(2025, 4, 13), "Il derby di Milano", tipoEvento.Pubblico, 75000);
//        Evento terzoEvento = new Evento("Compleanno Pupo", LocalDate.of(2025, 11, 27), "Il compleanno più atteso dell'anno", tipoEvento.Privato, 300);
//        Evento quartoEvento = new Evento("Compleanno Filippo", LocalDate.of(2025, 12, 6), "Il mio compleanno", tipoEvento.Privato, 30);
//        Evento quintoEvento = new Evento("Compleanno Rita", LocalDate.of(2025, 7, 9), "Il compleanno di Rita", tipoEvento.Privato, 40);

        Persona primaPersona = new Persona("Filippo", "Timo", "filtimo2002@gmail.com", LocalDate.of(2002, 12, 6), sesso.Maschio);
        Persona secondaPersona = new Persona("Marco", "Rossi", "marcorossi@gmail.com", LocalDate.of(1978, 3, 23), sesso.Maschio);

        Location primaLocation = new Location("Piazza Mazzini", "Lecce");
        Location secondaLocation = new Location("Piazza Sant'Oronzo", "Lecce");
        Location terzaLocation = new Location("Duomo di Lecce", "Lecce");

        // --------------------------------------------- SAVE ---------------------------------------------
//        eventoDao.save(primoEvento);
//        eventoDao.save(secondoEvento);
//        eventoDao.save(terzoEvento);
//        eventoDao.save(quartoEvento);
//        eventoDao.save(quintoEvento);

//        personeDao.save(primaPersona);
//        personeDao.save(secondaPersona);

//        locationDao.save(primaLocation);
//        locationDao.save(secondaLocation);
//        locationDao.save(terzaLocation);


        // --------------------------------------------- SAVE ---------------------------------------------


        entityManager.close();
        entityManagerFactory.close();
    }
}