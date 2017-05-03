package dao;

import model.Customer;
import model.Item;
import model.Role;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mario on 25.04.2017.
 */
public class ItemDao {
    private EntityManager em;

    public ItemDao(EntityManager em){
        this.em = em;
    }

    public List<Item> getItems(){
        List<Item> list = em.createQuery("SELECT i FROM Item i").getResultList();
        return list;
    }

    public boolean addItem(Item item){

        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(item);
            et.commit();
            return true;

        }catch(Exception e){
            e.printStackTrace();
            et.rollback();
            return false;
        }

    }
    public Item getItemById(int id){
        this.em.clear();
        return this.em.find(Item.class, id);
    }

}
