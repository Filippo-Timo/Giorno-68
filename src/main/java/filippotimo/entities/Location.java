package filippotimo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private UUID id;

    @Column
    private String nome;

    @Column
    private String citta;

    @ManyToMany(mappedBy = "categories")
    private List<Evento> eventi;

    public Location() {
    }

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id = " + id +
                ", nome = " + nome + '\'' +
                ", citta = " + citta + '\'' +
                '}';
    }
}
