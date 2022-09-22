/**
 * 
 */
package com.barry.cours.app.ws.ui.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * @author algas
 *
 */
@Data
@Getter
@Setter

public class UserDetailsRequest {
	
	@NotNull(message = "FirstName cannot be null")
	@NotEmpty(message = "FirstName cannot be empty")
	private String firstName;
	
	@NotNull(message = "LastName cannot be null")
	private String lastName;
	
	@NotNull(message = "Email cannot be null")
	private String email;
	
	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 16, message = "Password must be equal or greater than 8  characters or less than 16 characters")
	private String password;

}
