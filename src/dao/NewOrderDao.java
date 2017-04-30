package dao;

import model.Order;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by mario on 27.04.2017.
 */
public class NewOrderDao {
    private EntityManager em;

    public NewOrderDao(EntityManager em) {
        this.em = em;
    }

    public List getNewOrders() {
        List<Order> list = em.createQuery("Select o from Order o").getResultList();
        return list;
    }

    public Order getNewOrderById(int id) {
        this.em.clear();
        return this.em.find(Order.class, id);
    }

    public boolean addOrder(Order order) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(order);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }
}

