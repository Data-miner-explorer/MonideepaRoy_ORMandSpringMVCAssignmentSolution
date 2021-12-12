// mapping

package com.greatlearning.CRMapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class customers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
	private String LastName;
	
	@Column(name="Email")
	private String Email;
	
	public customers() {
		super();
	}

	public customers(String FirstName, String LastName, String Email) {
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Email = Email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName= LastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + "]";
	}
}