package dao;

import model.Storehouse;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by mario on 26.04.2017.
 */
public class StorehouseDao {
    private EntityManager em;

    public StorehouseDao(EntityManager em){
        this.em = em;
    }
    // change for item get, add, alter, insert
    public List getStorehouse(){
        List<Storehouse> list = em.createQuery("SELECT s FROM Storehouse s").getResultList();
        return list;
    }

    public Storehouse getStorehouseById(int id){
        this.em.clear();
        return this.em.find(Storehouse.class, id);
    }

    public boolean addStorehouse(Storehouse storehouse){

        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(storehouse);
            et.commit();
            return true;

        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
