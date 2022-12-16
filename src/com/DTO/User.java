package com.DTO;

import java.util.List;

public class User extends People {

	private int idUser;

	protected List<Permission> permissionList;
	public boolean login(String name, String password) {
		return false;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.classes.DTO.User{");
		sb.append("idUser=").append(idUser);
		sb.append(", permissionList=").append(permissionList);
		sb.append(", ").append(super.toString());
		sb.append('}');
		return sb.toString();
	}
}
