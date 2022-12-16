package com.main;

import com.BO.PersonBO;
import com.BO.UserBO;
import com.DTO.Account;
import com.DTO.Person;
import com.DTO.TypePerson;
import com.enums.Origin;
import com.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MainCreatePerson {

    public static void main(String[] args) {
        Person person = new Person();
        Account account = new Account();
        List<TypePerson> typePersonList = new ArrayList<TypePerson>();
        UserBO userBO = new UserBO();


        person.setName("Teste");
        person.setEmail("teste@teste.com");
        person.setPhone(999999999);
        person.setBirth(Util.StringToDate("1999-01-01"));
        person.setCpf_cnpj(999999999);
        person.setStreet("Rua Teste");
        person.setDistrict("Bairro Teste");
        person.setNumber(999);
        person.setComplement("Complemento Teste");
        person.setCreci("999999999");
        person.setOrigin(Origin.FACEBOOK);

        person.setPickup(userBO.select("joao"));

        account.setAccountNumber(999999);
        account.setAccountNumberDigit(9);
        account.setAgency(99999);
        account.setAgencyDigit(9);
        account.setBankName("Banco Teste");
        account.setBankNumber(999);
        account.setType("F");

        for (int i = 0; i < 3; i++) {
            TypePerson typePerson = new TypePerson();
            typePerson.setDescription(i);
            typePersonList.add(typePerson);
        }

        person.setAccount(account);
        person.setTypePersonList(typePersonList);


        PersonBO personBO = new PersonBO();

        personBO.insert(person);

    }
}
