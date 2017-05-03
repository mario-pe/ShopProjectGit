package dao;

import model.Customer;
import model.Role;
import org.hibernate.sql.Select;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by mario on 24.04.2017.
 */

public class CustomerDao {
    private EntityManager em;

    public CustomerDao(EntityManager em) {
        this.em = em;
    }

    public List<Customer> getCustomers() {
        List<Customer> list = em.createQuery("SELECT c FROM Customer c").getResultList();
        return list;
    }

    public boolean addCustomer(Customer customer) {
        this.em.clear();
        customer.setPassword(this.getMD5(customer.getPassword()));
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(customer);
            et.commit();
            return true;

        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }
    public String getRoleByLogin(String login){
        Role role =(Role) em.createQuery("Select r from Role r where r.login =:login " ).setParameter("login",login).getSingleResult();

        return role.getR();
    }

    public Customer getCustomerById(int id) {
        this.em.clear();
        return this.em.find(Customer.class, id);
    }

    public Customer getCustomerByLogin(String login) {
        this.em.clear();
        Customer customer = (Customer) em.createQuery("Select c from Customer c where c.login = :login").setParameter("login", login).getSingleResult();
        return customer;
    }

    public String getMD5(String dane) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        md5.update(dane.getBytes());
        BigInteger hasz = new BigInteger(1, md5.digest());
        String ready = hasz.toString(16);
        if (ready.length() == 31)
            ready = "0" + ready;
        return ready;

    }

    public boolean addRole(Customer c) {
        Role role = new Role();
        role.setLogin(c.getLogin());
        role.setR("customer");
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(role);
            et.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            return false;
        }
    }


}
