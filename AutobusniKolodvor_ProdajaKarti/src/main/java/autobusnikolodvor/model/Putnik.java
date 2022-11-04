package autobusnikolodvor.model;

import jakarta.persistence.Entity;

@Entity
public class Putnik extends Entitet {

    private String ime;
    private String prezime;
    private String email;
    private String datumRodjenja;

    public Putnik() {
        super();
    }

    public Putnik(String ime, String prezime, String email, String datumRodjenja, Integer sifra) {
        super(sifra);
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }
}
