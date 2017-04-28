package dao;

import model.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by mario on 24.04.2017.
 */
public class PaymentDao {
    private EntityManager em;

    public PaymentDao(EntityManager em){
        this.em = em;
    }

    public List getPayments(){
        List<Payment> list = em.createQuery("SELECT p FROM Payment p").getResultList();
        return list;
    }

    public Payment getPaymentById(int id){
        this.em.clear();
        return this.em.find(Payment.class, id);
    }

    public boolean addPayment(Payment payment){

        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(payment);
            et.commit();
            return true;

        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
