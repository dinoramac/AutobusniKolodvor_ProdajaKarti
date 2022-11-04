package autobusnikolodvor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Relacija extends Entitet {

    private String pocetnoStajaliste;
    private String zavrsnoStajaliste;
    private Date vrijemePolaska;
    private int trajanjeVoznje;
    
    @ManyToOne
    private Vozac vozac;
    
    @ManyToOne
    private Autobus autobus;

    public Relacija() {
        super();
    }

    public Relacija(Integer sifra, String pocetnoStajaliste, String zavrsnoStajaliste, Date vrijemePolaska,
            int trajanjeVoznje, Vozac vozac, Autobus autobus) {
        super(sifra);
        this.pocetnoStajaliste = pocetnoStajaliste;
        this.zavrsnoStajaliste = zavrsnoStajaliste;
        this.vrijemePolaska = vrijemePolaska;
        this.trajanjeVoznje = trajanjeVoznje;
        this.vozac = vozac;
        this.autobus = autobus;
    }

    public Date getVrijemePolaska() {
        return vrijemePolaska;
    }

    public void setVrijemePolaska(Date vrijemePolaska) {
        this.vrijemePolaska = vrijemePolaska;
    }

    public String getPocetnoStajaliste() {
        return pocetnoStajaliste;
    }

    public void setPocetnoStajaliste(String pocetnoStajaliste) {
        this.pocetnoStajaliste = pocetnoStajaliste;
    }

    public String getZavrsnoStajaliste() {
        return zavrsnoStajaliste;
    }

    public void setZavrsnoStajaliste(String zavrsnoStajaliste) {
        this.zavrsnoStajaliste = zavrsnoStajaliste;
    }

    public int getTrajanjeVoznje() {
        return trajanjeVoznje;
    }

    public void setTrajanjeVoznje(int trajanjeVoznje) {
        this.trajanjeVoznje = trajanjeVoznje;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }

}
