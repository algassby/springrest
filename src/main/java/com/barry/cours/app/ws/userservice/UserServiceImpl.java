/**
 * 
 */
package com.barry.cours.app.ws.userservice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barry.cours.app.ws.shared.Utils;
import com.barry.cours.app.ws.ui.model.request.UserDetailsRequest;
import com.barry.cours.app.ws.ui.model.response.UserRest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author algas
 *
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
	private Map<String, UserRest> users;
	private Utils utils;
	
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		super();
		this.utils = utils;
	}


	@Override
	public UserRest createUser(UserDetailsRequest detailsRequest) {
		
		log.info(detailsRequest.toString());
		if(users == null ) users =new HashMap<String, UserRest>();
		UserRest user = UserRest
				.builder()
				.userId(utils.generateUserId())
				.firstName(detailsRequest.getFirstName())
				.lastName(detailsRequest.getLastName())
				.email(detailsRequest.getEmail())
				.build();
		users.put(user.getUserId(), user);
		return user;
	}

}
