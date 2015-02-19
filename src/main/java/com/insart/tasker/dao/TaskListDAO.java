package com.insart.tasker.dao;

import com.insart.tasker.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Denis on 19.02.2015.
 */
public interface TaskListDAO extends JpaRepository<TaskList, Long> {

}
