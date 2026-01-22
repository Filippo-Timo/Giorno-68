package filippotimo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "partite_di_calcio")
public class PartitaDiCalcio extends Evento {

    @Column(nullable = false)
    private String squadraDiCasa;

    @Column(nullable = false)
    private String squadraOspite;

    @Column
    private String squadraVincente;

    @Column
    private int numGolCasa;

    @Column
    private int numGolOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento, int numeroMassimoPartecipanti, String squadraDiCasa, String squadraOspite, String squadraVincente, int numGolCasa, int numGolOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numGolCasa = numGolCasa;
        this.numGolOspite = numGolOspite;
    }


    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumGolCasa() {
        return numGolCasa;
    }

    public void setNumGolCasa(int numGolCasa) {
        this.numGolCasa = numGolCasa;
    }

    public int getNumGolOspite() {
        return numGolOspite;
    }

    public void setNumGolOspite(int numGolOspite) {
        this.numGolOspite = numGolOspite;
    }


    @Override
    public String toString() {
        return "PartitaDiCalcio { " +
                "squadraDiCasa = " + squadraDiCasa + '\'' +
                ", squadraOspite = " + squadraOspite + '\'' +
                ", squadraVincente = " + squadraVincente + '\'' +
                ", numGolCasa = " + numGolCasa +
                ", numGolOspite = " + numGolOspite +
                '}';
    }
}
