/**
 * 
 */
package com.barry.cours.app.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

/**
 * @author algas
 *
 */
@Service
public class Utils {

	public String generateUserId() {
		return UUID.randomUUID().toString();
	}
}
