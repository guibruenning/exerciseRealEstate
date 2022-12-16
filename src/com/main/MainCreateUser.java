package com.main;

import com.BO.PersonBO;
import com.BO.UserBO;
import com.DTO.Permission;
import com.DTO.User;

import java.util.ArrayList;
import java.util.List;

public class MainCreateUser {

    public static void main(String[] args) {

        User user = new User();
        user.setName("João");
        user.setEmail("asdasd@asda.com");
        user.setPhone(123456789);

        List<Permission> permissionList = new ArrayList<Permission>();



        Permission permission = new Permission();
        permission.setName("admin");

        permissionList.add(permission);
        user.setPermissionList(permissionList);

        System.out.println(user);

        UserBO userBO = new UserBO();

        userBO.insert(user);


    }
}
