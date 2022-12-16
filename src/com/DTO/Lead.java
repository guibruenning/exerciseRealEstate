package com.DTO;
public class Lead {

	private int idLead;

	private String name;

	private int phone;

	private String email;

	private Enum origin;

	public void createDeal(int idLastDeal, Deal deal) {

	}

	public int getIdLead() {
		return idLead;
	}

	public void setIdLead(int idLead) {
		this.idLead = idLead;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Enum getOrigin() {
		return origin;
	}

	public void setOrigin(Enum origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.classes.DTO.Lead{");
		sb.append("idLead=").append(idLead);
		sb.append(", name='").append(name).append('\'');
		sb.append(", phone=").append(phone);
		sb.append(", email='").append(email).append('\'');
		sb.append(", origin=").append(origin);
		sb.append('}');
		return sb.toString();
	}
}
