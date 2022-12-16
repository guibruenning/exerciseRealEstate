package com.DTO;

public class Stage {

	private int idStage;

	private String name;

	public int getIdStage() {
		return idStage;
	}

	public void setIdStage(int idStage) {
		this.idStage = idStage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.classes.DTO.Stage{");
		sb.append("id=").append(idStage);
		sb.append(", name='").append(name).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
