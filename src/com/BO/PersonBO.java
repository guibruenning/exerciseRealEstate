package com.BO;

import com.DAO.PersonDAO;
import com.DTO.Person;

import java.util.List;

public class PersonBO {

    public void insert(Person person) {
        PersonDAO personDAO = new PersonDAO();
        personDAO.insert(person);
    }

    public void update(Person person) {
        PersonDAO personDAO = new PersonDAO();
        personDAO.update(person);
    }

    public void delete(Person person) {
        PersonDAO personDAO = new PersonDAO();
        personDAO.delete(person);
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
