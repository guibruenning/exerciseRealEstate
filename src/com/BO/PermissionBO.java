package com.BO;

import com.DAO.PermissionDAO;
import com.DTO.Permission;

import java.util.List;

public class PermissionBO {

    public void insert(Permission permission) {
        PermissionDAO permissionDAO = new PermissionDAO();
        permissionDAO.insert(permission);
    }

    public void update(Permission permission) {
        PermissionDAO permissionDAO = new PermissionDAO();
        permissionDAO.update(permission);
    }

    public void delete(Permission permission) {
        PermissionDAO permissionDAO = new PermissionDAO();
        permissionDAO.delete(permission);
    }

    public Permission select(int id) {
        PermissionDAO permissionDAO = new PermissionDAO();
        return permissionDAO.select(id);
    }

    public Permission select(String name) {
        PermissionDAO permissionDAO = new PermissionDAO();
        return permissionDAO.select(name);
    }

    public List<Permission> selectAll() {
        PermissionDAO permissionDAO = new PermissionDAO();
        return permissionDAO.selectAll();
    }

}
