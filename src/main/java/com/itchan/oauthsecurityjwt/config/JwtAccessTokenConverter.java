package com.itchan.oauthsecurityjwt.config;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

import com.itchan.oauthsecurityjwt.model.AccessTokenMapper;

@Component
public class JwtAccessTokenConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

	@Override
	public void configure(org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter converter) {
		converter.setAccessTokenConverter(this);
		
	}

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		
		OAuth2Authentication auth = super.extractAuthentication(map);
		AccessTokenMapper accessDetails = new AccessTokenMapper();
		
		if (map.get("id") != null)
			accessDetails.setId((String)map.get("id"));
			
		if (map.get("userName") != null)
			accessDetails.setUserName((String)map.get("userName"));
		
		if (map.get("name") != null)
			accessDetails.setName((String)map.get("name"));
		
		auth.setDetails(accessDetails);
		
		return auth;
	}

	
	
	
}
