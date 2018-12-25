package br.com.virtualstore.virtualstoresecurity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;


public class UserModel implements Serializable{
	
	
	/**
	 * Paulo Diniz
	 * 24-12-2018
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String userName;
	private String password;
	private Collection<GrantedAuthority> grandedAuthoritiesList = new  ArrayList<>();
	
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
	public Collection<GrantedAuthority> getGrandedAuthoritiesList() {
		return grandedAuthoritiesList;
	}
	public void setGrandedAuthoritiesList(Collection<GrantedAuthority> grandedAuthoritiesList) {
		this.grandedAuthoritiesList = grandedAuthoritiesList;
	}
	
	
}
