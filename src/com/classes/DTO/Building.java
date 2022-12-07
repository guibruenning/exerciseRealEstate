package com.classes.DTO;
public class Building {

	private int idBuilding;

	private String name;

	private String description;

	private String purpuse;

	private String type;

	private int rooms;

	private int bedroom;

	private int bathroom;

	private int suite;

	private float totalArea;

	private float privateArea;

	private float usefullArea;

	private float amountSale;

	private float amountRent;

	private float amountSeason;

	private String street;

	private String district;

	private int number;

	private String complement;

	private String city;

	private String state;

	private String country;

	public void changeBuilding() {

	}

	public int getIdBuilding() {
		return idBuilding;
	}

	public void setIdBuilding(int idBuilding) {
		this.idBuilding = idBuilding;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPurpuse() {
		return purpuse;
	}

	public void setPurpuse(String purpuse) {
		this.purpuse = purpuse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getBedroom() {
		return bedroom;
	}

	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}

	public int getBathroom() {
		return bathroom;
	}

	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}

	public int getSuite() {
		return suite;
	}

	public void setSuite(int suite) {
		this.suite = suite;
	}

	public float getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(float totalArea) {
		this.totalArea = totalArea;
	}

	public float getPrivateArea() {
		return privateArea;
	}

	public void setPrivateArea(float privateArea) {
		this.privateArea = privateArea;
	}

	public float getUsefullArea() {
		return usefullArea;
	}

	public void setUsefullArea(float usefullArea) {
		this.usefullArea = usefullArea;
	}

	public float getAmountSale() {
		return amountSale;
	}

	public void setAmountSale(float amountSale) {
		this.amountSale = amountSale;
	}

	public float getAmountRent() {
		return amountRent;
	}

	public void setAmountRent(float amountRent) {
		this.amountRent = amountRent;
	}

	public float getAmountSeason() {
		return amountSeason;
	}

	public void setAmountSeason(float amountSeason) {
		this.amountSeason = amountSeason;
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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("com.classes.DTO.Building{");
		sb.append("idBuilding=").append(idBuilding);
		sb.append(", name='").append(name).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append(", purpuse='").append(purpuse).append('\'');
		sb.append(", type='").append(type).append('\'');
		sb.append(", rooms=").append(rooms);
		sb.append(", bedroom=").append(bedroom);
		sb.append(", bathroom=").append(bathroom);
		sb.append(", suite=").append(suite);
		sb.append(", totalArea=").append(totalArea);
		sb.append(", privateArea=").append(privateArea);
		sb.append(", usefullArea=").append(usefullArea);
		sb.append(", amountSale=").append(amountSale);
		sb.append(", amountRent=").append(amountRent);
		sb.append(", amountSeason=").append(amountSeason);
		sb.append(", street='").append(street).append('\'');
		sb.append(", district='").append(district).append('\'');
		sb.append(", number=").append(number);
		sb.append(", complement='").append(complement).append('\'');
		sb.append(", city='").append(city).append('\'');
		sb.append(", state='").append(state).append('\'');
		sb.append(", country='").append(country).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
