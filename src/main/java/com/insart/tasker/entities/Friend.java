package com.insart.tasker.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Nastya on 18.02.2015.
 */
@Entity
@Table(name = "friend")
public class Friend {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private Integer id;

    @Column(name = "flag")
    private Boolean flag;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "friend")
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


}