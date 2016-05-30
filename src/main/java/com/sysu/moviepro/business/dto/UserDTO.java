package com.sysu.moviepro.business.dto;

import com.sysu.moviepro.business.entity.User;

public class UserDTO {
	private int id;
	private String name;
	private String password;
	private String email;
	private int sex;
	private String telephone;
	private String description;
	
	public UserDTO() {
	}
	
	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
		password = user.getPassword();
		email = user.getEmail();
		sex = user.getSex();
		telephone = user.getTelephone();
		description = user.getDescription();
	}
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", sex=" + sex
				+ ", telephone=" + telephone + ", description=" + description + "]";
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
