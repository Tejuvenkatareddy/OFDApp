package com.capgemini.OFDApp.domain;

/**
 * This is the Login bean which travels from layer to layer
 * @author Soumyadip Pal
 */
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/*
 * The Login bean
 */
@Entity
@Table(name="login")
public class Login {
	/**
	 * id of login bean which is a primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id; 
	/**
	 * User name for login
	 */
	@Column(name="user_name")
	private String userName; 
	/**
	 * Password for login
	 */
	@Column(name="password")
	private String password;
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_role", 
//	      joinColumns = @JoinColumn(name="user_id", referencedColumnName="user_id"),
//	      inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName="role_id"))
//  	private Set<Role> roles = new HashSet<>();
	/**
	 * Role for login
	 */
	@NotBlank(message="Please enter a role")
	private String role;
	/**
	 * Default constructor
	 */
	public Login() {
		super();
	}
	/**
	 * Parameterized constructor
	 * @param id
	 * @param userName
	 * @param password
	 * @param role
	 */
	public Login(Integer id, String userName, String password, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role.toUpperCase();
	}
	/**
	 * Setters and Getters
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role=role.toUpperCase();
	}
	/**
	 * ToString method
	 */
	@Override
	public String toString() {
		return "Login [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}
