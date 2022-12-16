package com.DAO;

import com.DTO.Person;
import com.DTO.TypePerson;
import com.connection.ConnectionReal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Person_Has_TypePersonDAO {

    final String TABLE_NAME = "person_has_typeperson";

    public boolean insert(Person person) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "INSERT INTO " + TABLE_NAME + " (idPerson, idTypePerson) VALUES (?, ?)";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            for (TypePerson typePerson : person.getTypePersonList()) {
                ps.setInt(1, person.getIdPerson());
                ps.setInt(2, typePerson.getIdTypePerson());
                ps.executeUpdate();
            }

            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Person person, TypePerson typePerson) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "DELETE FROM " + TABLE_NAME + " WHERE idPerson = ? AND idTypePerson = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, person.getIdPerson());
            ps.setInt(2, typePerson.getIdTypePerson());

            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Person person, List<TypePerson> typePersonList) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "UPDATE " + TABLE_NAME + " SET idPerson = ?, idTypePerson = ? WHERE idPerson = ? AND idTypePerson = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            for (TypePerson typePerson : typePersonList) {
                ps.setInt(1, person.getIdPerson());
                ps.setInt(2, typePerson.getIdTypePerson());
                ps.setInt(3, person.getIdPerson());
                ps.setInt(4, typePerson.getIdTypePerson());
                ps.executeUpdate();
            }

            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<TypePerson> select(Person person) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE idPerson = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, person.getIdPerson());
            ResultSet rs = ps.executeQuery();

            List<TypePerson> typePersonList = new ArrayList<TypePerson>();

            while (rs.next()) {
                TypePerson typePerson = new TypePerson();
                typePerson.setIdTypePerson(rs.getInt("idTypePerson"));
                typePersonList.add(typePerson);
            }

            ps.close();
            conn.close();

            return typePersonList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
