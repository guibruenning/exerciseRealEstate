package com.BO;

import com.DAO.UserDAO;
import com.DTO.User;

import java.util.List;

public class UserBO {

    public void insert(User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.insert(user);
    }

    public void update(User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.update(user);
    }

    public void delete(User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.delete(user);
    }

    public User select(int id) {
        UserDAO userDAO = new UserDAO();
        return userDAO.select(id);
    }

    public User select(String login) {
        UserDAO userDAO = new UserDAO();
        return userDAO.select(login);
    }

    public User select(User user) {
        UserDAO userDAO = new UserDAO();
        return userDAO.select(user);
    }

    public List<User> selectAll() {
        UserDAO userDAO = new UserDAO();
        return userDAO.selectAll();
    }

}
