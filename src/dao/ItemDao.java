package dao;

import model.Item;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mario on 25.04.2017.
 */
public class ItemDao {
    private EntityManager em;

    public ItemDao(EntityManager em) {
        this.em = em;
    }

    public List<Item> getItems() {
        List<Item> list = em.createQuery("SELECT i FROM Item i").getResultList();
        return list;
    }

    public boolean addItem(Item item) {

        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(item);
            et.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            return false;
        }

    }

    public Item getItemById(int id) {
        this.em.clear();
        return this.em.find(Item.class, id);
    }

    public boolean updateItemById(int id, String producent, String model, double price, int stock) {
        EntityTransaction et = em.getTransaction();
        Item item = getItemById(id);
        boolean flag=false;


        if (!item.getProducent().equals(producent) && !producent.equals("")) {
            et.begin();
            item.setProducent(producent);
            et.commit();
        }

        if (!item.getModel().equals(model) && !model.equals("")) {
            et.begin();
            item.setModel(model);
            et.commit();
        }

        if (item.getPrice() != price && price != -1) {
            et.begin();
            item.setPrice(price);
            et.commit();
        }
        if (item.getStock() != stock && stock != -1) {
            et.begin();
            item.setStock(stock);
            et.commit();
        }
        return true;
    }
    public boolean deleteItemById(int id){
        Item item = getItemById(id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(item);
        et.commit();
        return true;
    }
}
