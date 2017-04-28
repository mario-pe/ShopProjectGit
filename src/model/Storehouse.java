package model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by mario on 26.04.2017.
 */
@Entity
@Table(name = "storehouse")
public class Storehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private int stock;

    @OneToMany(targetEntity=Item.class,mappedBy="storehouse",fetch=FetchType.EAGER)
    private Set<Item> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
