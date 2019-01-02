package bean;

public class Userdetails {

	int id;
	String name;
	String surname;
	String location;
	long phoneNumber;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Userdetails(int id, String name, String surname, String location, long phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.location = location;
		this.phoneNumber = phoneNumber;
	}
	public Userdetails() {
		super();
	}
	
	
}
