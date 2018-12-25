package br.com.virtualstore.virtualstoresecurity.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import br.com.virtualstore.virtualstoresecurity.model.UserModel;

import java.util.List;

@Repository
public class UserDAO {
	
	JdbcTemplate jdbcTemplate;
	
	/**
	 * Paulo Diniz
	 * 24-12-2018
	 */
	public UserModel getUserDetails(String username)
	{
		Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
		String sqlQuery = "SELECT * FROM USERS WHERE USERNAME=?";
		List<UserModel> list = jdbcTemplate.query(sqlQuery, new String[] { username }, (ResultSet rs, int rowNum) -> {
			UserModel userModel = new UserModel();
			userModel.setUserName(username);
			userModel.setPassword(rs.getString("PASSWORD"));
			return userModel;
		});

		if (list != null && list.size() > 0) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
			grantedAuthoritiesList.add(grantedAuthority);
			list.get(0).setGrandedAuthoritiesList(grantedAuthoritiesList);
			return list.get(0);
		}

		return null;
	}

}
