package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author akvang - Alexander Vang
 * CIS175 - Spring 2023
 * Feb 9, 2023
 */
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public User(String name) {
		super();
		this.name = name;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
