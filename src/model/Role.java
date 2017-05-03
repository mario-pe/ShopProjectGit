package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mario on 03.05.2017.
 */
@Entity
@Table(name="r")
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String r;
    private String login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getR() {
        return r;
    }

    public void setR(String role) {
        this.r = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
