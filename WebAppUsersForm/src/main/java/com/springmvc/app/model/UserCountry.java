package com.springmvc.app.model;

public enum UserCountry {
	
	BULGARIA("Bulgaria"),
	ITALY("Italy"),
	FRANCE("France"),
	GERMANY("Germany");
	
	private String countryName;

	private UserCountry(String countryName) {
		this.countryName = countryName;
	}
	
	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}
}
