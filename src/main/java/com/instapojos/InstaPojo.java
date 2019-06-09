package com.instapojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstaPojo{
private String name;
@Id
private String mail;
private String pwd;
private String mob;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getMob() {
	return mob;
}
public void setMob(String mob) {
	this.mob = mob;
}

}
