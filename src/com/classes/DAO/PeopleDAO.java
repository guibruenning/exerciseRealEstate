package com.classes.DAO;

import com.classes.DTO.People;
import com.classes.connection.ConnctionReal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PeopleDAO {

    final String table = "people";

    public boolean insert(People people){
        try{
            Connection conn = ConnctionReal.getConnection();

            String sql = "INSERT INTO " + table + " (name, email, telephone) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, people.getName());
            stmt.setString(2, people.getEmail());
            stmt.setInt(3, people.getTelephone());
            stmt.execute();
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(People people){
        try{
            Connection conn = ConnctionReal.getConnection();

            String sql = "UPDATE " + table + " SET name = ?, email = ?, telephone = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, people.getName());
            stmt.setString(2, people.getEmail());
            stmt.setInt(3, people.getTelephone());
            stmt.setInt(4, people.getId());
            stmt.execute();
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(People people){
        try{
            Connection conn = ConnctionReal.getConnection();

            String sql = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, people.getId());
            stmt.execute();
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public People searchId(People people){
        try{
            Connection conn = ConnctionReal.getConnection();

            String sql = "SELECT * FROM " + table + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, people.getId());
            stmt.execute();
            stmt.close();
            conn.close();
            return people;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public People searchName(People people){
        try{
            Connection conn = ConnctionReal.getConnection();

            String sql = "SELECT * FROM " + table + " WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, people.getName());
            stmt.execute();
            stmt.close();
            conn.close();
            return people;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public People searchEmail(People people){
        try{
            Connection conn = ConnctionReal.getConnection();

            String sql = "SELECT * FROM " + table + " WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, people.getEmail());
            stmt.execute();
            stmt.close();
            conn.close();
            return people;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public People searchPhone(People people){
        try{
            Connection conn = ConnctionReal.getConnection();

            String sql = "SELECT * FROM " + table + " WHERE telephone = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, people.getTelephone());
            stmt.execute();
            stmt.close();
            conn.close();
            return people;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<People> listPeople(){
        try{
            Connection conn = ConnctionReal.getConnection();

            String sql = "SELECT * FROM " + table;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            conn.close();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean exists(People people){
        try{
            Connection conn = ConnctionReal.getConnection();

            String sql = "SELECT * FROM " + table;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
