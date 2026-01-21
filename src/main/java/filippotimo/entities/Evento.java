package filippotimo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

// Ora che ho creato la prima classe farò due cose che andranno fatte PER OGNI CLASSE/TABELLA:
// 1) Definisco la classe come Entity, ovvero come una tabella del db
// 2) Aggiungo la classe su persistence.xml dove c'è il TODO (se non lo faccio la nuova entity verrà ignorata)

@Entity
// Annotazione obbligatoria. Ci serve per definire che questa classe dovrà venir mappata a una specifica tabella nel DB
// Sarà Hibernate a creare in automatico la tabella in questione (oppure se già esistente proverà a modificarla secondo quanto trova in questa classe)
// se utilizziamo l'impostazione <property name="hibernate.hbm2ddl.auto" value="update"/> nel persistence.xml
@Table(name = "eventi") // "eventi" sarà il nome della tabella nel DB
// classe = nome al singolare con iniziale in maiuscolo
// tabella = nome al plurale con iniziale in minuscolo
public class Evento {

    @Id
    // Annotazione OBBLIGATORIA. Dichiaro che questo attributo dovrà corrispondere alla colonna PRIMARY KEY della tabella eventi
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Annotazione OPZIONALE però molto consigliata. Serve per chiedere al DB di generare lui
    // i valori per la PK. IDENTITY significa che invece di biginteger vogliamo usare un bigserial.
    // È consigliabile scrivere questo @GeneratedValue PRIMA di runnare il main per far si che in pgAdmin la colonna id prenda Serial come valore e non BigInteger
    // se prima di scrivere @GeneratedValue runno la console in main allora mi toccherà andare su pgAdmin, eliminare la tabella e runnare di nuovo la console nel main
    private long id; // long corrisponde al tipo biginteger (a meno di non specificare diversamente)

    @Column(name = "nome_evento", nullable = false, length = 50)
    // lenght = 50 serve per impostare la lunghezza massima a 50 caratteri
    private String titolo;

    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;

    @Column(name = "descrizione_evento", columnDefinition = "TEXT") // Per far si che il dato sia di tipo Text
    private String descrizione;

    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING)
    // <-- Gli ENUM di default vengono "convertiti" in smallint (che non è quello che probabilmente vogliamo)
    // Tramite @Enumerated(EnumType.STRING) specifico che la colonna dovrà essere di tipo varchar
    private tipoEvento tipoEvento;

    @Column(name = "max_partecipanti_evento", nullable = false)
    private int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni;

    @ManyToMany
    @JoinTable(name = "eventi_locations",
            joinColumns = @JoinColumn(name = "evento_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "location_id", nullable = false))
    private List<Location> locations;

    //QUI VA IL MANY TO ONE

    public Evento() {
        // OBBLIGATORIO PER TUTTE LE ENTITIES AVERE UN COSTRUTTORE VUOTO! Viene usato da JPA per costruire degli oggetti quando
        // leggeremo delle righe dalla tabella
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public tipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id = " + id +
                ", titolo = " + titolo + '\'' +
                ", dataEvento = " + dataEvento +
                ", descrizione = " + descrizione + '\'' +
                ", tipoEvento = " + tipoEvento +
                ", numeroMassimoPartecipanti = " + numeroMassimoPartecipanti +
                ", partecipazioni = " + partecipazioni +
                ", locations = " + locations +
                '}';
    }
}