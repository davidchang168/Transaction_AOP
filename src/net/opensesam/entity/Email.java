package net.opensesam.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "email")
public class Email {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "address")
    private String address;

    @ManyToMany(mappedBy = "emails")
    private Set<User> users = new HashSet<User>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<User> getUsers() {
        return users;
    }
}
