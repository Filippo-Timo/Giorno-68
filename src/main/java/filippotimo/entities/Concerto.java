package filippotimo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Concerto extends Evento {

    @Column
    private tipoConcerto tipo;

    @Column
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(tipoConcerto tipo, boolean inStreaming) {
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
        return "Concerto{" +
                "tipo = " + tipo +
                ", inStreaming = " + inStreaming +
                '}';
    }
}
