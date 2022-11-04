package autobusnikolodvor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Rezervacija extends Entitet {

    private Date datumRezervacije;
    
    @ManyToOne
    private Relacija Relacija;
    
    @ManyToOne
    private Putnik putnik;

    public Rezervacija() {
        super();
    }

    public Rezervacija(Date datumRezervacije, Relacija Relacija, Putnik putnik, Integer sifra) {
        super(sifra);
        this.datumRezervacije = datumRezervacije;
        this.Relacija = Relacija;
        this.putnik = putnik;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public Relacija getRelacija() {
        return Relacija;
    }

    public void setRelacija(Relacija relacija) {
        Relacija = relacija;
    }

    public Putnik getPutnik() {
        return putnik;
    }

    public void setPutnik(Putnik putnik) {
        this.putnik = putnik;
    }
}
