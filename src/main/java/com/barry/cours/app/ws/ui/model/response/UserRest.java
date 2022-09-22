/**
 * 
 */
package com.barry.cours.app.ws.ui.model.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author algas
 *
 */
@Data
@Builder
public class UserRest {
	private String userId;
	private String firstName;
	private String lastName;
	private String email;

}
