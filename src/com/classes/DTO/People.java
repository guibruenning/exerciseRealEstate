package com.classes.DTO;

public class People {

	private int id;

	private String name;

	private String email;

	private int telephone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.classes.DTO.People{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", telephone=").append(telephone);
		sb.append('}');
		return sb.toString();
	}
}
