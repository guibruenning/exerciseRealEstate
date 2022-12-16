package com.DAO;

import com.BO.PermissionBO;
import com.BO.UserBO;
import com.BO.User_Has_PermissionBO;
import com.DTO.Permission;
import com.DTO.User;
import com.connection.ConnectionReal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    final String NOMEDATABELA = "user";

    public boolean insert(User user) {
        Connection conn = ConnectionReal.getConnection();
        PermissionBO permissionBO = new PermissionBO();
        User_Has_PermissionBO user_has_permissionBO = new User_Has_PermissionBO();

        if(select(user.getName()) != null)
            if(select(user.getName()).getIdUser() != 0) return false;

        String sql = "INSERT INTO " + NOMEDATABELA + " (name, email, phone) VALUES (?, ?, ?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setInt(3, user.getPhone());
            ps.executeUpdate();

            for(Permission permission : user.getPermissionList()) {
                Permission permi = permissionBO.select(permission.getName());
                if(permi.getName() == null) {
                    permissionBO.insert(permission);
                }
                permi = permissionBO.select(permission.getName());
                user_has_permissionBO.insert(this.select(user.getName()).getIdUser(), permissionBO.select(permi.getIdPermission()).getIdPermission());
            }

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(User user) {
        try {
            Connection conn = ConnectionReal.getConnection();
            String sql = "UPDATE " + NOMEDATABELA + " SET name = ?, phone = ?, login = ?, password = ? WHERE idUser = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getPhone());
            ps.setInt(5, user.getIdUser());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }

    public boolean delete(User user) {
        try {
            Connection conn = ConnectionReal.getConnection();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idUSer = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getIdUser());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }

    public List<User> selectAll() {
        try{
            Connection conn = ConnectionReal.getConnection();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("idUser"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getInt("phone"));
                users.add(user);
            }
            ps.close();
            conn.close();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User select(int id) {
        try{
            Connection conn = ConnectionReal.getConnection();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idUser = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            User user = new User();
            if(rs.next()) {
                user.setIdUser(rs.getInt("idUser"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getInt("phone"));
            }
            ps.close();
            conn.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public User select(String name) {
        try{
            Connection conn = ConnectionReal.getConnection();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE name = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            User user = new User();
            if(rs.next()) {
                user.setIdUser(rs.getInt("idUser"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getInt("phone"));
            }else {
                return null;
            }
            ps.close();
            conn.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public User select(User user) {
        try{
            Connection conn = ConnectionReal.getConnection();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE name = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ResultSet rs = ps.executeQuery();
            User user1 = new User();
            if(rs.next()) {
                user1.setIdUser(rs.getInt("idUser"));
                user1.setName(rs.getString("name"));
                user1.setPhone(rs.getInt("phone"));
            }else {
                return null;
            }
            ps.close();
            conn.close();
            return user1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
