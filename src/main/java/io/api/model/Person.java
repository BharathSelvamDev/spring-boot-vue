package io.api.model;

public class Person {
	private int id;
	private String name;
	private String city;
	private String phoneNo;
	private String hobby;
	private boolean isAdmin;

	public Person() {
		super();
	}

	public Person(int id, String name, String city, String phoneNo, String hobby, boolean isAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.phoneNo = phoneNo;
		this.hobby = hobby;
		this.isAdmin = isAdmin;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
