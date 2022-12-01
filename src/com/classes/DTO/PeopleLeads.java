package com.classes.DTO;

import java.util.Date;

public class PeopleLeads {

	private Date birth;

	private String companyLink;

	private int cpf_cnpj;

	private String street;

	private String district;

	private int number;

	private String complement;

	private String city;

	private String state;

	private String country;

	private Account account;

	private People people;

	public int age() {
		return 0;
	}

	public boolean isExists(String name) {
		return false;
	}

}
