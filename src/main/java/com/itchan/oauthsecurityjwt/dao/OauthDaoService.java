package com.itchan.oauthsecurityjwt.dao;



import com.itchan.oauthsecurityjwt.model.UserEntity;


public interface OauthDaoService {

	public UserEntity getUserDetails(String emailId);
	
}
