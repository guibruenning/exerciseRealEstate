package com.classes.BO;

import com.classes.DAO.PeopleDAO;
import com.classes.DTO.People;

import java.util.List;

public class PeopleBO {
    public boolean insert(People people) {
        if (exists(people) != true) {
            PeopleDAO peopleDAO = new PeopleDAO();
            return peopleDAO.insert(people);
        }
        return false;
    }

    private boolean exists(People people) {
        PeopleDAO peopleDAO = new PeopleDAO();
        return peopleDAO.exists(people);
    }

    public boolean update(People people) {
        PeopleDAO peopleDAO = new PeopleDAO();
        return peopleDAO.update(people);
    }

    public boolean delete(People people) {
        PeopleDAO peopleDAO = new PeopleDAO();
        return peopleDAO.delete(people);
    }

    public People searchId(People people) {
        PeopleDAO peopleDAO = new PeopleDAO();
        return peopleDAO.searchId(people);
    }

    public People searchName(People people) {
        PeopleDAO peopleDAO = new PeopleDAO();
        return peopleDAO.searchName(people);
    }

    public People searchEmail(People people) {
        PeopleDAO peopleDAO = new PeopleDAO();
        return peopleDAO.searchEmail(people);
    }

    public People searchPhone(People people) {
        PeopleDAO peopleDAO = new PeopleDAO();
        return peopleDAO.searchPhone(people);
    }

    public List<People> listPeople() {
        PeopleDAO peopleDAO = new PeopleDAO();
        return peopleDAO.listPeople();
    }
}
