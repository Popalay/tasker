package com.insart.tasker.dao;

import com.insart.tasker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Evgeniy James on 19.02.2015.
 */
@Repository
public interface UserDAO extends JpaRepository<User, Long> {

}
