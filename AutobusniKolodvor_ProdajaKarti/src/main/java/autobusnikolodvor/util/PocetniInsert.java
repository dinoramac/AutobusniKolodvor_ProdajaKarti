/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autobusnikolodvor.util;

import autobusnikolodvor.model.Relacija;
import autobusnikolodvor.model.Vozac;
import autobusnikolodvor.model.Autobus;
import autobusnikolodvor.model.Operater;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Dino
 */
public class PocetniInsert {

    private List<Relacija> relacije;
    private List<Vozac> vozaci;
    private List<Autobus> autobusi;

    private Session sess;
    private Faker faker;

    public PocetniInsert() {
        relacije = new ArrayList<>();
        vozaci = new ArrayList<>();
        autobusi = new ArrayList<>();
        sess = HibernateUtil.getSession();
        faker = new Faker();
        sess.beginTransaction();
        kreirajAutobuse(10);
        kreirajVozace(10);
        kreirajRelacije(10);
        kreirajOperatera();
        //
        //
        sess.getTransaction().commit();
        HibernateUtil.reset();
    }

    private void kreirajRelacije(int broj) {
        for (int i = 0; i < broj; i++) {
            relacije.add(kreirajRelaciju());
        }
    }

    private Relacija kreirajRelaciju() {
        Relacija r = new Relacija();
        r.setPocetnoStajaliste(faker.address().cityName());
        r.setZavrsnoStajaliste(faker.address().cityName());
        r.setTrajanjeVoznje(faker.number().numberBetween(30, 240));
        r.setVrijemePolaska(new Date());
        r.setAutobus(autobusi.get(0));
        r.setVozac(vozaci.get(0));

        sess.persist(r);
        return r;
    }

    private void kreirajVozace(int broj) {
        for (int i = 0; i < broj; i++) {
            vozaci.add(kreirajVozaca());
        }
    }

    private Vozac kreirajVozaca() {
        Vozac v = new Vozac();
        v.setIme(faker.name().firstName());
        v.setPrezime(faker.name().lastName());
        v.setOib(Pomocno.dovuciOib());
        
        sess.persist(v);
        return v;
    }

    private void kreirajAutobuse(int broj) {
        for (int i = 0; i < broj; i++) {
            autobusi.add(kreirajAutobus());
        }
    }

    private Autobus kreirajAutobus() {
        Autobus a = new Autobus();
        a.setBrojAutobusa(faker.number().numberBetween(999, 10000));
        a.setBrojSjedala(faker.number().numberBetween(45, 56));
        a.setDostupnostAutobusa(faker.bool().bool());

        sess.persist(a);
        return a;
    }

    private void kreirajOperatera() {
        Operater o = new Operater();
        o.setIme("Marija");
        o.setPrezime("Javic");
        o.setEmail("mjavic@edunova.hr");
        o.setLozinka(BCrypt.hashpw("m", BCrypt.gensalt()));
        sess.persist(o);
    }

}
