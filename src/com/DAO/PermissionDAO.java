package com.DAO;

import com.DTO.Permission;
import com.connection.ConnectionReal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PermissionDAO {

    final String NAME_TABLE = "permission";

    public void insert(Permission permission) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "INSERT INTO " + NAME_TABLE + " (name, idDadPermission) VALUES (?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, permission.getName());
            if (permission.getPermissionDad() != null) {
                ps.setInt(2, permission.getPermissionDad().getIdPermission());
            }
            else{
                ps.setNull(2, java.sql.Types.INTEGER);
            }
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Permission permission) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "UPDATE " + NAME_TABLE + " SET name = ?, idDadPermission = ? WHERE idPermission = ?";

        if(select(permission.getName()) != null) return;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, permission.getName());
            if (permission.getPermissionDad() != null) {
                ps.setInt(2, permission.getPermissionDad().getIdPermission());
            }
            ps.setInt(3, permission.getIdPermission());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void delete(Permission permission) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "DELETE FROM " + NAME_TABLE + " WHERE idPermission = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, permission.getIdPermission());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Permission select(int id) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "SELECT * FROM " + NAME_TABLE + " WHERE idPermission = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Permission permission = new Permission();
            if (rs.next()) {
                permission.setIdPermission(rs.getInt("idPermission"));
                permission.setName(rs.getString("name"));
                permission.setPermissionDad(select(rs.getInt("idDadPermission")));
            }
            rs.close();
            ps.close();
            conn.close();
            return permission;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Permission select(String name) {
        Connection conn = ConnectionReal.getConnection();

        String sql = "SELECT * FROM " + NAME_TABLE + " WHERE name = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            Permission permission = new Permission();
            if (rs.next()) {
                permission.setIdPermission(rs.getInt("idPermission"));
                permission.setName(rs.getString("name"));
                permission.setPermissionDad(select(rs.getInt("idDadPermission")));
            }
            rs.close();
            ps.close();
            conn.close();
            return permission;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Permission> selectAll() {
        Connection conn = ConnectionReal.getConnection();

        String sql = "SELECT * FROM " + NAME_TABLE;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Permission> permissions = new ArrayList<>();
            while (rs.next()) {
                Permission permission = new Permission();
                permission.setIdPermission(rs.getInt("idPermission"));
                permission.setName(rs.getString("name"));
                permission.setPermissionDad(select(rs.getInt("idDadPermission")));
                permissions.add(permission);
            }
            rs.close();
            ps.close();
            conn.close();
            return permissions;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
