package dao;

import model.OrderItem;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mario on 25.04.2017.
 */
public class OrderItemDao {
    private EntityManager em;

    public OrderItemDao(EntityManager em){
        this.em = em;
    }

    public List<OrderItem> getItems(){
        List<OrderItem> list = em.createQuery("SELECT oi FROM OrderItem oi").getResultList();
        return list;
    }

    public boolean addOrderItem(OrderItem orderItem){

        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(orderItem);
            et.commit();
            return true;

        }catch(Exception e){
            e.printStackTrace();
            et.rollback();
            return false;
        }

    }
    public OrderItem getItemById(int id){
        this.em.clear();
        return this.em.find(OrderItem.class, id);
    }


}

