package com.insart.tasker.dao;

/**
 * Created by Nastya on 18.02.2015.
 */

import com.insart.tasker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserDAO extends JpaRepository<User, Long> {
}
