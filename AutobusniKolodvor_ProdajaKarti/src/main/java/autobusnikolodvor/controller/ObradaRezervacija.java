/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autobusnikolodvor.controller;

import autobusnikolodvor.model.Rezervacija;
import autobusnikolodvor.util.AutobusniException;
import java.util.List;

/**
 *
 * @author Dino
 */
public class ObradaRezervacija extends Obrada<Rezervacija> {

    @Override
    public List read() {
        return session.createQuery("from Rezervacija", Rezervacija.class).list();
    }

    @Override
    protected void kontrolaCreate() throws AutobusniException {
        kontrolaDatumRezervacije();
        kontrolaRelacija();
        kontrolaPutnik();
    }

    @Override
    protected void kontrolaUpdate() throws AutobusniException {
        kontrolaCreate();
    }

    @Override
    protected void kontrolaDelete() throws AutobusniException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String getNazivEntiteta() {
        return "Rezervacija";
    }

    private void kontrolaDatumRezervacije() throws AutobusniException {
        if (entitet.getDatumRezervacije() == null) {
            throw new AutobusniException("Datum obavezan");
        }
    }

    private void kontrolaRelacija() throws AutobusniException {
        if (entitet.getDatumRezervacije() == null) {
            throw new AutobusniException("Relacija obavezna");
        }
    }

    private void kontrolaPutnik() throws AutobusniException {
        if (entitet.getDatumRezervacije() == null) {
            throw new AutobusniException("Putnik obavezan");
        }
    }

}
