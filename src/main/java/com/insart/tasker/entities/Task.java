package com.insart.tasker.entities;

import com.insart.tasker.enums.TaskStatus;

import javax.persistence.*;
import java.util.Date;

import static com.insart.tasker.entities.Task.TABLE_NAME;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 0:43
 */
@Entity
@Table(name = TABLE_NAME)
public class Task {

    public static final String TABLE_NAME = "task";

    private Long id;
    private User author;
    private User executor;
    private TaskList taskList;
    private String title;
    private String description;
    private TaskStatus status;
    private Date created;
    private Date updated;

    @Id
    @Column(name = "id")
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

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Column(name = "updated")
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @OneToOne
    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    @OneToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @OneToOne
    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

}
