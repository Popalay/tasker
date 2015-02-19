package com.insart.tasker.entities;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "tasklist")
public class TaskList {

    private Long id;
    private String title;
    private Collection<Task> tasks = new ArrayList<>();

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany
    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}