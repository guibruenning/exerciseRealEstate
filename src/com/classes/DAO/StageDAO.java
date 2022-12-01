package com.classes.DAO;

import com.classes.DTO.Stage;
import com.classes.connection.ConnctionReal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StageDAO {

    final String NOMEDATABELA = "stage";

    public boolean insert(Stage stage) {
        try {
            Connection conn = ConnctionReal.getConnection();
            String sql = "INSERT INTO " + NOMEDATABELA + " (name) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, stage.getName());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Stage stage) {
        try {
            Connection conn = ConnctionReal.getConnection();
            String sql = "UPDATE " + NOMEDATABELA + " SET name = ? WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, stage.getName());
            ps.setInt(2, stage.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }

    public boolean delete(Stage stage) {
        try {
            Connection conn = ConnctionReal.getConnection();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, stage.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }

    public Stage searchId(Stage stage) {
        try {
            Connection conn = ConnctionReal.getConnection();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, stage.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                stage.setId(rs.getInt("id"));
                stage.setName(rs.getString("name"));
            }
            rs.close();
            ps.close();
            conn.close();
            return stage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Stage> litsStage() {
        try {
            Connection conn = ConnctionReal.getConnection();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Stage> lista = new ArrayList<Stage>();
            while (rs.next()) {
                Stage stage = new Stage();
                stage.setId(rs.getInt("id"));
                stage.setName(rs.getString("name"));
                lista.add(stage);
            }
            rs.close();
            ps.close();
            conn.close();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean exists(Stage stage) {
        try {
            Connection conn = ConnctionReal.getConnection();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, stage.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            rs.close();
            ps.close();
            conn.close();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
