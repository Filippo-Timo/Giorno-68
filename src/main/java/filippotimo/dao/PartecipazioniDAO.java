package filippotimo.dao;

import filippotimo.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioniDAO {
    private EntityManager em;

    public PartecipazioniDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione attendance) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(attendance);
            t.commit();
            System.out.println("Partecipazione all'evento " + attendance.getEvento() + " per la persona " + attendance.getPersona().getCognome() + ", creata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Partecipazione findById(UUID id) {
        return em.find(Partecipazione.class, id);
    }

    public void findByIdAndDelete(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Partecipazione found = em.find(Partecipazione.class, id);
            if (found != null) {
                em.remove(found);
                t.commit();
                System.out.println("Partecipazione cancellata");
            } else System.out.println("Partecipazione non trovata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
