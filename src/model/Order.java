package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * Created by mario on 27.04.2017.
 */
@Entity
@Table(name="neworder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String payment;
    private String shipping;
    private double shippingCost;
    private Timestamp date;
    private Double wholeValue;

    @OneToMany(targetEntity= OrderItem.class,mappedBy="order",fetch=FetchType.EAGER)
    private Set<OrderItem> orderItems;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "customer_id")//, referencedColumnName="id")
    private Customer customer;

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getWholeValue() {
        return wholeValue;
    }

    public void setWholeValue(Double wholeValue) {
        this.wholeValue = wholeValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double wholeValueOrder(List<OrderItem> orderItemList, double shipping){
        double value = 0;
        for(OrderItem oi:orderItemList) {
            value = oi.getQuantity() * oi.getPrice();
        }
        value += shipping;
        return value;
    }
}
