/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autobusnikolodvor.controller;

import autobusnikolodvor.model.Operater;
import autobusnikolodvor.util.AutobusniException;
import jakarta.persistence.NoResultException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Dino
 */
public class ObradaOperater extends Obrada<Operater>{

    public Operater autoriziraj(String email, char[] lozinka) {
        Operater o;
        try {
            o = session.createQuery("from Operater where email=:email",
                    Operater.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        
        if(BCrypt.checkpw(new String(lozinka), o.getLozinka())){
            Operater vrati = new Operater();
            vrati.setSifra(o.getSifra());
            vrati.setIme(o.getIme());
            vrati.setPrezime(o.getPrezime());
            vrati.setEmail(o.getEmail());
            return vrati;     
        }
        
        return null;
    }

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater", Operater.class).list();
    }

    @Override
    protected String getNazivEntiteta() {
        return "Operater";
    }

    @Override
    protected void kontrolaCreate() throws AutobusniException {
        kontrolaIme();
    }

    @Override
    protected void kontrolaUpdate() throws AutobusniException {
        
    }

    @Override
    protected void kontrolaDelete() throws AutobusniException {
        
    }
    
    private void kontrolaIme() throws AutobusniException{
       kontrolaImeMoraBitiUneseno();
    }
    
    private void kontrolaImeMoraBitiUneseno() throws AutobusniException {
        if(entitet.getIme()==null || entitet.getIme().trim().isEmpty()){
            throw new AutobusniException("Ime obavezno");
        }
                
    }
    
}
