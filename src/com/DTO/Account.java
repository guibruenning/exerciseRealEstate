package com.DTO;
public class Account {

	private int idAccount;

	private int agency;

	private int agencyDigit;

	private int accountNumber;

	private int accountNumberDigit;

	private String bankName;

	private int bankNumber;

	private String Type;

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public int getAgencyDigit() {
		return agencyDigit;
	}

	public void setAgencyDigit(int agencyDigit) {
		this.agencyDigit = agencyDigit;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountNumberDigit() {
		return accountNumberDigit;
	}

	public void setAccountNumberDigit(int accountNumberDigit) {
		this.accountNumberDigit = accountNumberDigit;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(int bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.classes.DTO.Account{");
		sb.append("idAccount=").append(idAccount);
		sb.append(", agency=").append(agency);
		sb.append(", agencyDigit=").append(agencyDigit);
		sb.append(", accountNumber=").append(accountNumber);
		sb.append(", accountNumberDigit=").append(accountNumberDigit);
		sb.append(", bankName='").append(bankName).append('\'');
		sb.append(", bankNumber=").append(bankNumber);
		sb.append(", Type=").append(Type);
		sb.append('}');
		return sb.toString();
	}
}
