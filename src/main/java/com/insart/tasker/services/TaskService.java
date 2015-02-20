package com.insart.tasker.services;

import com.insart.tasker.dao.TaskDAO;
import com.insart.tasker.entities.Task;
import com.insart.tasker.entities.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 1:26
 */
@Service
public class TaskService {
private EntityManager em= Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

    public void addTaskList(List<TaskList> taskList)
    {
        em.getTransaction().begin();
        em.persist(taskList);
        em.getTransaction().commit();
    }

    public void save(Task task)
    {
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
    }
    public void delete(Task task)
    {
        em.getTransaction().begin();
        em.remove(task);
        em.getTransaction().commit();
    }
    public Task get(int id)
    {
        return em.find(Task.class,id);
    }
    public void update(Task task)
    {
        em.getTransaction().begin();
        em.merge(task);
        em.getTransaction().commit();
    }

    public List<Task> getAll() {
        TypedQuery<Task> namedQuery = em.createNamedQuery("Task.getAll",Task.class);
        return namedQuery.getResultList();
    }
}
