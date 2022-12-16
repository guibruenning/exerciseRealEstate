package com.DTO;
public class Deal extends People {

	private int idDeal;

	private float amount;

	public void createPeople(int lastIdPeople, Person newPerson) {

	}

	public boolean isPeople(String name) {
		return false;
	}

	public int getIdDeal() {
		return idDeal;
	}

	public void setIdDeal(int idDeal) {
		this.idDeal = idDeal;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.classes.DTO.Deal{");
		sb.append("idDeal=").append(idDeal);
		sb.append(", amount=").append(amount);
		sb.append(", ").append(super.toString());
		sb.append('}');
		return sb.toString();
	}
}
