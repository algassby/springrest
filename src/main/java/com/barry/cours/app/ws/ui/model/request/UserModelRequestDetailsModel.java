/**
 * 
 */
package com.barry.cours.app.ws.ui.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
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
@Builder
public class UserModelRequestDetailsModel {
	@NotNull(message = "FirstName cannot be null")
	@NotEmpty(message = "FirstName cannot be empty")
	private String firstName;
	
	@NotNull(message = "LastName cannot be null")
	private String lastName;
	
}
