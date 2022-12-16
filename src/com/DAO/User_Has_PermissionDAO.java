package com.DAO;

import com.BO.User_Has_PermissionBO;
import com.DTO.Permission;
import com.connection.ConnectionReal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User_Has_PermissionDAO {

    final String NAME_TABLE = "user_has_permission";

    public void insert(int user, int permission) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "INSERT INTO " + NAME_TABLE + " (idUser, idPermission) VALUES (?, ?)";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user);
            ps.setInt(2, permission);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int user, int permission) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "DELETE FROM " + NAME_TABLE + " WHERE idUser = ? AND idPermission = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user);
            ps.setInt(2, permission);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int user) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "DELETE FROM " + NAME_TABLE + " WHERE idUser = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByPermission(int permission) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "DELETE FROM " + NAME_TABLE + " WHERE idPermission = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, permission);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Permission> select(int user) {
        Connection conn = ConnectionReal.getConnection();
        User_Has_PermissionBO user_has_permissionBO = new User_Has_PermissionBO();

        String sql = "SELECT idPermission FROM " + NAME_TABLE + " WHERE idUser = ?";
        List<Permission> permissions = new ArrayList<>();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Permission permission = new Permission();
                permission.setIdPermission(rs.getInt("idPermission"));
                permission.setName(rs.getString("name"));
                permission.setPermissionDad(user_has_permissionBO.selectByDad(rs.getInt("idDadPermission")));
                permissions.add(permission);
            }
            rs.close();
            ps.close();
            conn.close();
            return permissions;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public Permission selectByDad(int idDadPermission){

        Connection conn = ConnectionReal.getConnection();

        String sql = "SELECT * FROM " + NAME_TABLE + " WHERE idDadPermission = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDadPermission);
            ResultSet rs = ps.executeQuery();
            Permission permission = new Permission();
            if(rs.next()){
                permission.setIdPermission(rs.getInt("idPermission"));
                permission.setName(rs.getString("name"));
            }
            rs.close();
            ps.close();
            conn.close();
            return permission;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(int user, int permission) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "UPDATE " + NAME_TABLE + " SET idPermission = ? WHERE idUser = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, permission);
            ps.setInt(2, user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
