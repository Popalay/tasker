package com.insart.tasker.services;

import com.insart.tasker.dao.UserDao;
import com.insart.tasker.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Evgeniy James on 19.02.2015.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> userList(){return userDao.findAll();}
}

