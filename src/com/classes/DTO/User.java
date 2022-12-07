package com.classes.DTO;

public class User extends People {

	private int idUser;

	private String login;

	private String password;
	public boolean login(String name, String password) {
		return false;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.classes.DTO.User{");
		sb.append("idUser=").append(idUser);
		sb.append(", login='").append(login).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", ").append(super.toString());
		sb.append('}');
		return sb.toString();
	}
}
