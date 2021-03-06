package com.insart.tasker.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user")
    public class User implements Serializable{

    private Long id;
    private String name;
    private String email;
    private String password;
    private Collection<User> users = new ArrayList<>();
    private Collection<TaskList> taskLists = new ArrayList<>();
    private Collection<User> friendsRequest = new ArrayList<>();
    private Collection<User> incomingFriends = new ArrayList<>();

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", users=" + users +
                ", taskLists=" + taskLists +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @OneToMany
    public Collection<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(Collection<TaskList> taskLists) {
        this.taskLists = taskLists;
    }

    @OneToMany
    public Collection<User> getFriendsRequest() {
        return friendsRequest;
    }

    public void setFriendsRequest(Collection<User> friendsRequest) {
        this.friendsRequest = friendsRequest;
    }

    @OneToMany
    public Collection<User> getIncomingFriends() {
        return incomingFriends;
    }

    public void setIncomingFriends(Collection<User> incomingFriends) {
        this.incomingFriends = incomingFriends;
    }
}