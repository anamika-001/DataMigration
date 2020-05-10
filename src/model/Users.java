package model;

public class Users {
 private byte id;
 private String name;
 private String city;
 private String contact;
public Users(byte id, String name, String city, String contact) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
	this.contact = contact;
}
public Users() {}
public byte getId() {
	return id;
}
public void setId(byte id) {
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
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
 

}
