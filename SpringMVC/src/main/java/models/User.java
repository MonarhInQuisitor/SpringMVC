package models;

public class User {

private String Login;
private String password;
private String password1;
private String name;
private String gender;
private String region;
private String comment;
@Override
public String toString() {
	return " Login=" + Login + ", password=" + password + ", name=" + name + ", gender=" + gender
			+ ", region=" + region + ", comment=" + comment + "]";

}
public String getLogin() {
	return Login;
}
public void setLogin(String login) {
	Login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPassword1() {
	return password1;
}
public void setPassword1(String password1) {
	this.password1 = password1;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getRegion() {
	return region;
}
public void setRegion(String region) {
	this.region = region;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
}
