package com.seismaismais.praizer.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.praizer.auth.model.User;
import com.seismaismais.praizer.auth.model.UserProfile;
import com.seismaismais.praizer.auth.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService_delete {

	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	public User loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		return user;
	}

	@Transactional(readOnly = true)
	public List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UserProfile userProfile : user.getUserProfiles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
		}
		return authorities;
	}

}
