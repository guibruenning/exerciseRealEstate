package com.DTO;

public class Permission {

	private int idPermission;

	private String name;

	private Permission permissionDad;

	public int getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(int idPermission) {
		this.idPermission = idPermission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Permission getPermissionDad() {
		return permissionDad;
	}

	public void setPermissionDad(Permission permissionDad) {
		this.permissionDad = permissionDad;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.DTO.Permission{");
		sb.append("idPermission=").append(idPermission);
		sb.append(", name='").append(name).append('\'');
		sb.append(", permissionDad=").append(permissionDad);
		sb.append('}');
		return sb.toString();
	}
}
