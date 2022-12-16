package com.BO;

import com.DAO.Person_Has_TypePersonDAO;
import com.DTO.Person;
import com.DTO.TypePerson;

import java.util.List;

public class Person_Has_TypePersonBO {

    public boolean insert(Person person) {
        Person_Has_TypePersonDAO person_has_typePersonDAO = new Person_Has_TypePersonDAO();
        return person_has_typePersonDAO.insert(person);
    }

    public boolean delete(Person person, TypePerson typePerson) {
        Person_Has_TypePersonDAO person_has_typePersonDAO = new Person_Has_TypePersonDAO();
        return person_has_typePersonDAO.delete(person, typePerson);
    }

    public boolean update(Person person, List<TypePerson> typePersonList) {
        Person_Has_TypePersonDAO person_has_typePersonDAO = new Person_Has_TypePersonDAO();
        return person_has_typePersonDAO.update(person, typePersonList);
    }

    public List<TypePerson> select(Person person) {
        Person_Has_TypePersonDAO person_has_typePersonDAO = new Person_Has_TypePersonDAO();
        return person_has_typePersonDAO.select(person);
    }
}
