package dao;

import model.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by mario on 24.04.2017.
 */
public class AddressDao {
    private EntityManager em;

    public AddressDao(EntityManager em){
        this.em = em;
    }

    public List getAddress(){
        List<Address> list = em.createQuery("Select a from Address a").getResultList();
        return list;
    }

    public Address getAddressById(int id){
        this.em.clear();
        return this.em.find(Address.class, id);
    }

    public boolean addAddress(Address ad){
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(ad);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
