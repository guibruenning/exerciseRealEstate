package com.classes.DTO;

import java.util.Date;

public class Person extends People {

	private int idPerson;

	private Date birth;

	private int cpf_cnpj;

	private String street;

	private String district;

	private int number;

	private String complement;

	private String city;

	private String state;

	private String country;

	private Enum origin;

	private String creci;

	public int age() {
		return 0;
	}

	public boolean isExists(String name) {
		return false;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(int cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Enum getOrigin() {
		return origin;
	}

	public void setOrigin(Enum origin) {
		this.origin = origin;
	}

	public String getCreci() {
		return creci;
	}

	public void setCreci(String creci) {
		this.creci = creci;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.classes.DTO.Person{");
		sb.append("idPerson=").append(idPerson);
		sb.append(", birth=").append(birth);
		sb.append(", cpf_cnpj=").append(cpf_cnpj);
		sb.append(", street='").append(street).append('\'');
		sb.append(", district='").append(district).append('\'');
		sb.append(", number=").append(number);
		sb.append(", complement='").append(complement).append('\'');
		sb.append(", city='").append(city).append('\'');
		sb.append(", state='").append(state).append('\'');
		sb.append(", country='").append(country).append('\'');
		sb.append(", origin=").append(origin);
		sb.append(", creci='").append(creci).append('\'');
		sb.append(", ").append(super.toString());
		sb.append('}');
		return sb.toString();
	}
}
