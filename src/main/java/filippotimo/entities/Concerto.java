package filippotimo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "concerti")
public class Concerto extends Evento {

    @Column
    private tipoConcerto tipo;

    @Column
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento, int numeroMassimoPartecipanti, tipoConcerto tipo, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.tipo = tipo;
        this.inStreaming = inStreaming;
    }

    public tipoConcerto getTipo() {
        return tipo;
    }

    public void setTipo(tipoConcerto tipo) {
        this.tipo = tipo;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto { " +
                "tipo = " + tipo +
                ", inStreaming = " + inStreaming +
                '}';
    }
}
