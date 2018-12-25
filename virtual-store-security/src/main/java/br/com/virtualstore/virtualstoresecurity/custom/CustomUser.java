package br.com.virtualstore.virtualstoresecurity.custom;

import org.springframework.security.core.userdetails.User;

import br.com.virtualstore.virtualstoresecurity.model.UserModel;

public class CustomUser extends User {

	/**
	 * Paulo Diniz
	 * 24-12-2018
	 * CustomUser
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomUser(UserModel userModel){
		super(userModel.getUserName(), userModel.getPassword(), userModel.getGrandedAuthoritiesList());
		
	}

}
