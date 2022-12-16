package com.BO;

import com.DAO.PersonDAO;
import com.DTO.Person;

import java.util.List;

public class PersonBO {

    public boolean insert(Person person) {
        PersonDAO personDAO = new PersonDAO();
        return personDAO.insert(person);
    }

    public boolean update(Person person) {
        PersonDAO personDAO = new PersonDAO();
        return personDAO.update(person);
    }

    public boolean delete(Person person) {
        PersonDAO personDAO = new PersonDAO();
        return personDAO.delete(person);
    }

    public Person select(int id) {
        PersonDAO personDAO = new PersonDAO();
        return personDAO.selectId(id);
    }

    public List<Person> selectAll() {
        PersonDAO personDAO = new PersonDAO();
        return personDAO.selectAll();
    }

}
