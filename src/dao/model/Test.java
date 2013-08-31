package dao.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/27/13
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity(name="test")
public class Test {

    @Column(name="id")
    Integer id;

    @Column(name="name")
    String name;

    @Column(name="email")
    String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
