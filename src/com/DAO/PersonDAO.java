package com.DAO;

import com.BO.AccountBO;
import com.BO.Person_Has_TypePersonBO;
import com.BO.UserBO;
import com.DTO.Account;
import com.DTO.Person;
import com.DTO.User;
import com.connection.ConnectionReal;
import com.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PersonDAO {
    final String TABLE_NAME = "person";

    public boolean insert(Person person) {
        Connection conn = ConnectionReal.getConnection();
        Person_Has_TypePersonBO person_has_typePersonBO = new Person_Has_TypePersonBO();
        AccountBO accountBO = new AccountBO();
        UserBO userBO = new UserBO();
        if(this.select(person.getName(), person.getEmail()) != null)
            if (this.select(person.getName(), person.getEmail()).getIdPerson() != 0) return false;
        String sql = "INSERT INTO " + TABLE_NAME + " (name, email, phone, birth, cpf_cnpj, street, district, number, complement, city, state, country, origin, creci, idAccount, idPickup) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getEmail());
            ps.setInt(3, person.getPhone());
            ps.setDate(4, Util.dateUtiltoDateSql(person.getBirth()));
            ps.setInt(5, person.getCpf_cnpj());
            ps.setString(6, person.getStreet());
            ps.setString(7, person.getDistrict());
            ps.setInt(8, person.getNumber());
            ps.setString(9, person.getComplement());
            ps.setString(10, person.getCity());
            ps.setString(11, person.getState());
            ps.setString(12, person.getCountry());
            ps.setInt(13, person.getOrigin().getValue());
            ps.setString(14, person.getCreci());

            if(accountBO.select(person.getAccount()).getAccountNumber() == 0 && person.getAccount().getAccountNumber() != 0) {
                accountBO.insert(person.getAccount());
            }

            ps.setInt(15, accountBO.select(person.getAccount()).getIdAccount());

            if(person.getPickup() != null &&  userBO.select(person.getPickup().getName()).getIdUser() == 0) {
                userBO.insert(person.getPickup());
            }
            ps.setInt(16, userBO.select(person.getPickup()).getIdUser());
            ps.executeUpdate();

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Person person) {
        Connection conn = ConnectionReal.getConnection();
        Person_Has_TypePersonBO person_has_typePersonBO = new Person_Has_TypePersonBO();
        AccountBO accountBO = new AccountBO();
        UserBO userBO = new UserBO();


        String sql = "UPDATE " + TABLE_NAME + " SET name = ?, email = ?, phone = ?, birth = ?, cpf_cnpj = ?, street = ?, district = ?, number = ?, complement = ?, city = ?, state = ?, country = ?, origin = ?, creci = ?, idAccount = ? WHERE id = ?;";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getEmail());
            ps.setInt(3, person.getPhone());
            ps.setDate(4, Util.dateUtiltoDateSql(person.getBirth()));
            ps.setInt(5, person.getCpf_cnpj());
            ps.setString(6, person.getStreet());
            ps.setString(7, person.getDistrict());
            ps.setInt(8, person.getNumber());
            ps.setString(9, person.getComplement());
            ps.setString(10, person.getCity());
            ps.setString(11, person.getState());
            ps.setString(12, person.getCountry());
            ps.setInt(13, person.getOrigin().getValue());
            ps.setString(14, person.getCreci());
            ps.setInt(15, accountBO.select(person.getAccount()).getIdAccount());
            ps.setInt(16, userBO.select(person.getPickup()).getIdUser());
            ps.executeUpdate();

            person.setIdPerson(selectName(person.getName()).getIdPerson());;
            person_has_typePersonBO.insert(person);

            ps.close();
            conn.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Person person) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?;";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, person.getIdPerson());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Person> selectAll() {
        Connection conn = ConnectionReal.getConnection();

        String sql = "SELECT * FROM " + TABLE_NAME + ";";
        AccountBO accountBO = new AccountBO();

        List<Person> list = new ArrayList<Person>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setIdPerson(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getInt("phone"));
                person.setBirth(Util.dateSqltoDateUtil(rs.getDate("birth")));
                person.setCpf_cnpj(rs.getInt("cpf_cnpj"));
                person.setStreet(rs.getString("street"));
                person.setDistrict(rs.getString("district"));
                person.setNumber(rs.getInt("number"));
                person.setComplement(rs.getString("complement"));
                person.setCity(rs.getString("city"));
                person.setState(rs.getString("state"));
                person.setCountry(rs.getString("country"));
                person.setOrigin(Util.getOrigin(rs.getInt("origin")));
                person.setCreci(rs.getString("creci"));
                person.setAccount(accountBO.select(rs.getInt("idAccount")));
                list.add(person);
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Person select(String name, String email){
        Connection conn = ConnectionReal.getConnection();

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE name = ? AND email = ?;";
        AccountBO accountBO = new AccountBO();

        Person person = new Person();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                person.setIdPerson(rs.getInt("idPerson"));
                person.setName(rs.getString("name"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getInt("phone"));
                person.setBirth(Util.dateSqltoDateUtil(rs.getDate("birth")));
                person.setCpf_cnpj(rs.getInt("cpf_cnpj"));
                person.setStreet(rs.getString("street"));
                person.setDistrict(rs.getString("district"));
                person.setNumber(rs.getInt("number"));
                person.setComplement(rs.getString("complement"));
                person.setCity(rs.getString("city"));
                person.setState(rs.getString("state"));
                person.setCountry(rs.getString("country"));
                person.setOrigin(Util.getOrigin(rs.getInt("origin")));
                person.setCreci(rs.getString("creci"));
                person.setAccount(accountBO.select(rs.getInt("idAccount")));
            }
            ps.close();
            conn.close();
            return person;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Person selectId(int id) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?;";
        AccountBO accountBO = new AccountBO();

        Person person = new Person();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                person.setIdPerson(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getInt("phone"));
                person.setBirth(Util.dateSqltoDateUtil(rs.getDate("birth")));
                person.setCpf_cnpj(rs.getInt("cpf_cnpj"));
                person.setStreet(rs.getString("street"));
                person.setDistrict(rs.getString("district"));
                person.setNumber(rs.getInt("number"));
                person.setComplement(rs.getString("complement"));
                person.setCity(rs.getString("city"));
                person.setState(rs.getString("state"));
                person.setCountry(rs.getString("country"));
                person.setOrigin(Util.getOrigin(rs.getInt("origin")));
                person.setCreci(rs.getString("creci"));
                person.setAccount(accountBO.select(rs.getInt("idAccount")));
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return person;
    }

    public Person selectEmail(String email) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE email = ?;";
        AccountBO accountBO = new AccountBO();

        Person person = new Person();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                person.setIdPerson(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getInt("phone"));
                person.setBirth(Util.dateSqltoDateUtil(rs.getDate("birth")));
                person.setCpf_cnpj(rs.getInt("cpf_cnpj"));
                person.setStreet(rs.getString("street"));
                person.setDistrict(rs.getString("district"));
                person.setNumber(rs.getInt("number"));
                person.setComplement(rs.getString("complement"));
                person.setCity(rs.getString("city"));
                person.setState(rs.getString("state"));
                person.setCountry(rs.getString("country"));
                person.setOrigin(Util.getOrigin(rs.getInt("origin")));
                person.setCreci(rs.getString("creci"));
                person.setAccount(accountBO.select(rs.getInt("idAccount")));
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    public Person selectName(String name){
        Connection conn = ConnectionReal.getConnection();

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE name = ?;";
        AccountBO accountBO = new AccountBO();

        Person person = new Person();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                person.setIdPerson(rs.getInt("idPerson"));
                person.setName(rs.getString("name"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getInt("phone"));
                person.setBirth(Util.dateSqltoDateUtil(rs.getDate("birth")));
                person.setCpf_cnpj(rs.getInt("cpf_cnpj"));
                person.setStreet(rs.getString("street"));
                person.setDistrict(rs.getString("district"));
                person.setNumber(rs.getInt("number"));
                person.setComplement(rs.getString("complement"));
                person.setCity(rs.getString("city"));
                person.setState(rs.getString("state"));
                person.setCountry(rs.getString("country"));
                person.setOrigin(Util.getOrigin(rs.getInt("origin")));
                person.setCreci(rs.getString("creci"));
                person.setAccount(accountBO.select(rs.getInt("idAccount")));
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }
}
