package com.DTO;
public class TypePerson {

	private int idTypePerson;

	private int description;

	public int getIdTypePerson() {
		return idTypePerson;
	}

	public void setIdTypePerson(int idTypePerson) {
		this.idTypePerson = idTypePerson;
	}

	public int getDescription() {
		return description;
	}

	public void setDescription(int description) {
		this.description = description;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.classes.DTO.typePerson{");
		sb.append("idTypePerson=").append(idTypePerson);
		sb.append(", description=").append(description);
		sb.append('}');
		return sb.toString();
	}
}
