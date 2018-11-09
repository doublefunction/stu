package com.tarena.entity;

import java.io.Serializable;

public class Course implements Serializable{
	
   /**
	 * 
	 */
	private static final long serialVersionUID = -5827154690873078405L;

   private Integer score;
   private User user;

public Integer getScore() {
	return score;
}
public void setScore(Integer score) {
	this.score = score;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
   
}
