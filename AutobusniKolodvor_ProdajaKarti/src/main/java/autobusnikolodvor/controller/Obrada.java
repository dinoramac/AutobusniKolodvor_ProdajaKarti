/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autobusnikolodvor.controller;

import autobusnikolodvor.model.Entitet;
import autobusnikolodvor.util.AutobusniException;
import autobusnikolodvor.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Dino
 */
public abstract class Obrada<T extends Entitet> {
    
    protected T entitet;
    protected Session session;
    
    public abstract List<T> read();
    protected abstract void kontrolaCreate() throws AutobusniException;
    protected abstract void kontrolaUpdate() throws AutobusniException;
    protected abstract void kontrolaDelete() throws AutobusniException;
    protected abstract String getNazivEntiteta();
    
    public Obrada() {
        this.session = HibernateUtil.getSession();
    }
    
    public void create() throws AutobusniException{
        if (entitet == null) {
            throw new AutobusniException(getNazivEntiteta() + " nije konstruiran");
        }
        kontrolaCreate();
        persist();
    }
    
    public void update() throws AutobusniException{
        kontrolaUpdate();
        persist();
    }
    
    public void delete() throws AutobusniException{
        kontrolaDelete();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
    }
    
    private void persist(){
        session.beginTransaction();
        session.persist(this.entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    
}
