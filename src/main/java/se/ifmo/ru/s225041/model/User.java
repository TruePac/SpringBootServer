package se.ifmo.ru.s225041.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@Column(name="user_id") 
	private long id;
	
	@Column(name = "password")
	private String password;
	
	protected User() {
	}

	public User(Long id,  String pswrd) {
		this.id = id;
		this.password = pswrd;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

}
