package dao;

import model.Shipping;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by mario on 24.04.2017.
 */
public class ShippingDao {
    private EntityManager em;

    public ShippingDao(EntityManager em){
        this.em = em;
    }

    public List getShipping(){
        List<Shipping> list = em.createQuery("SELECT s FROM Shipping s").getResultList();
        return list;
    }

    public Shipping getShippingById(int id){
        this.em.clear();
        return this.em.find(Shipping.class, id);
    }


    public boolean addShipping(Shipping shipping){

        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(shipping);
            et.commit();
            return true;

        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
