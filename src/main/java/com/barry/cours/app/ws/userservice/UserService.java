package com.barry.cours.app.ws.userservice;

import com.barry.cours.app.ws.ui.model.request.UserDetailsRequest;
import com.barry.cours.app.ws.ui.model.response.UserRest;

public interface UserService {

	public UserRest createUser(UserDetailsRequest detailsRequest);
}
