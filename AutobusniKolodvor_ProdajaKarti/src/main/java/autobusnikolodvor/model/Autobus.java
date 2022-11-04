package autobusnikolodvor.model;

import jakarta.persistence.Entity;

@Entity
public class Autobus extends Entitet {

    private int brojAutobusa;
    private int brojSjedala;
    private Boolean dostupnostAutobusa;

    public Autobus() {
        super();
    }

    public Autobus(Integer sifra, int brojAutobusa, int brojSjedala, Boolean dostupnostAutobusa) {
        super(sifra);
        this.brojAutobusa = brojAutobusa;
        this.brojSjedala = brojSjedala;
        this.dostupnostAutobusa = dostupnostAutobusa;
    }

    public int getBrojAutobusa() {
        return brojAutobusa;
    }

    public void setBrojAutobusa(int brojAutobusa) {
        this.brojAutobusa = brojAutobusa;
    }

    public int getBrojSjedala() {
        return brojSjedala;
    }

    public void setBrojSjedala(int brojSjedala) {
        this.brojSjedala = brojSjedala;
    }

    public Boolean getDostupnostAutobusa() {
        return dostupnostAutobusa;
    }

    public void setDostupnostAutobusa(Boolean dostupnostAutobusa) {
        this.dostupnostAutobusa = dostupnostAutobusa;
    }

}
