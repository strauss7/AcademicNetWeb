package br.com.yuji.entities;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long registration;
	private String name;
	private String telephone;
	private String email;
	private Date dateRegister;

	public Student() {

	}

	public Student(Long registration) {
		super();
		this.registration = registration;
	}

	public Student(Long registration, String name) {
		super();
		this.registration = registration;
		this.name = name;
	}

	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	@Override
	public String toString() {
		return "Student [registration=" + registration + ", name=" + name + ", telephone=" + telephone + ", email="
				+ email + ", dateRegister=" + dateRegister + "]";
	}

}
