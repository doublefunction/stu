package com.tarena.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class User implements Serializable{
      /**
	 * 
	 */
	private static final long serialVersionUID = -8011712579916934574L;
	private Integer id;
      private String name;
      private String password;
      private String token;
      private String nick;
	private Set<Course> courses; 
	
	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public User(Integer id, String name, String password, String token, String nick) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.token = token;
		this.nick = nick;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
      
}
