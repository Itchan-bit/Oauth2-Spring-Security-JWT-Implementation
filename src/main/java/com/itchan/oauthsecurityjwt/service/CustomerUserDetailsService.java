package com.itchan.oauthsecurityjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itchan.oauthsecurityjwt.dao.OauthDaoService;
import com.itchan.oauthsecurityjwt.model.CustomUser;
import com.itchan.oauthsecurityjwt.model.UserEntity;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	OauthDaoService oauthDaoService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		UserEntity userEntity = null;
		
		try {
			userEntity = oauthDaoService.getUserDetails(username);
			if(userEntity != null && userEntity.getId() != null && !"".equalsIgnoreCase(userEntity.getId())) {
				
				CustomUser customUser = new CustomUser(userEntity);
				return customUser;	
			}
			
			else {
				throw new UsernameNotFoundException("User" + username + "was not found");
			}
			
		} catch (Exception e) {
			throw new UsernameNotFoundException("User" + username + "was not found");
		}
		
		
	}

}
