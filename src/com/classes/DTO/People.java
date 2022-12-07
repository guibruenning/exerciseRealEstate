package com.classes.DTO;

public class People {

	private String name;

	private String email;

	private int phone;

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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.classes.DTO.People{");
		sb.append(", name='").append(name).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", telephone=").append(phone);
		sb.append('}');
		return sb.toString();
	}
}
