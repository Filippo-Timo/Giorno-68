package filippotimo.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue
    @Column(name = "partecipazione_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;


    @Column
    private stato stato;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento, stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public UUID getId() {
        return id;
    }

    public stato getStato() {
        return stato;
    }

    public void setStato(stato stato) {
        this.stato = stato;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id = " + id +
                ", persona = " + persona +
                ", evento = " + evento +
                ", stato = " + stato +
                '}';
    }

}
