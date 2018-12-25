package br.com.virtualstore.virtualstoresecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.virtualstore.virtualstoresecurity.custom.CustomUser;
import br.com.virtualstore.virtualstoresecurity.dao.UserDAO;
import br.com.virtualstore.virtualstoresecurity.model.UserModel;
@Service
public class CustomDetailsService implements UserDetailsService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserModel userModel = userDAO.getUserDetails(userName);
		CustomUser customUser = new CustomUser(userModel);
		return customUser;
	}

}
