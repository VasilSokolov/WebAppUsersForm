package com.springmvc.app.model;

public class User {

	private Long id;
	private String userName;
	private String email;
	private UserCountry country;

	public User() {}

	public User(Long id, String userName, String email, UserCountry country) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.country = country;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the country
	 */
	public UserCountry getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(UserCountry country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", country=" + country + "]";
	}

}
