package com.BO;

import com.DAO.User_Has_PermissionDAO;
import com.DTO.Permission;

import java.util.List;

public class User_Has_PermissionBO {

    public void insert(int user, int permission) {
        User_Has_PermissionDAO user_has_permissionDAO = new User_Has_PermissionDAO();
        user_has_permissionDAO.insert(user, permission);
    }

    public void update(int user, int permission) {
        User_Has_PermissionDAO user_has_permissionDAO = new User_Has_PermissionDAO();
        user_has_permissionDAO.update(user, permission);
    }

    public void delete(int user, int permission) {
        User_Has_PermissionDAO user_has_permissionDAO = new User_Has_PermissionDAO();
        user_has_permissionDAO.delete(user, permission);
    }

    public void delete(int user) {
        User_Has_PermissionDAO user_has_permissionDAO = new User_Has_PermissionDAO();
        user_has_permissionDAO.delete(user);
    }

    public void deleteByPermission(int permission) {
        User_Has_PermissionDAO user_has_permissionDAO = new User_Has_PermissionDAO();
        user_has_permissionDAO.deleteByPermission(permission);
    }

    public List<Permission> select(int user) {
        User_Has_PermissionDAO user_has_permissionDAO = new User_Has_PermissionDAO();
        return user_has_permissionDAO.select(user);
    }

    public Permission selectByDad(int idDadPermission){
        User_Has_PermissionDAO user_has_permissionDAO = new User_Has_PermissionDAO();
        return user_has_permissionDAO.selectByDad(idDadPermission);
    }

}
