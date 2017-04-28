package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by mario on 25.04.2017.
 */
@Entity
@Table
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;

    @OneToMany(targetEntity=Address.class,mappedBy="customer",fetch=FetchType.EAGER)

//    @OneToMany
    private Set<Address> addresses;


    @OneToMany(targetEntity= Order.class,mappedBy="customer",fetch=FetchType.EAGER)
//    @OneToMany
    private Set<Order> orders;

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
