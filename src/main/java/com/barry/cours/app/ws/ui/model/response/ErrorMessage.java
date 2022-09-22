/**
 * 
 */
package com.barry.cours.app.ws.ui.model.response;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * @author algas
 *
 */
@Data
@Builder
public class ErrorMessage {

	private Date dateTime;
	private String message;
}
