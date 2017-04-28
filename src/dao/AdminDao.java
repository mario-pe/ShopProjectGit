package dao;

import model.Admin;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by mario on 24.04.2017.
 */
public class AdminDao {
    private EntityManager em;

    public AdminDao(EntityManager em){
        this.em = em;
    }

    public List getAddress(){
        List<Admin> list = em.createQuery("Select a from Admin a").getResultList();
        return list;
    }

    public Admin getAdminById(int id){
        this.em.clear();
        return this.em.find(Admin.class, id);
    }

    public boolean addAdmin(Admin ad){
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
