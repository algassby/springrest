/**
 * 
 */
package com.barry.cours.app.ws.controller;



import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barry.cours.app.ws.ui.exception.UserServiceException;
import com.barry.cours.app.ws.ui.model.request.UserDetailsRequest;
import com.barry.cours.app.ws.ui.model.request.UserModelRequestDetailsModel;
import com.barry.cours.app.ws.ui.model.response.UserRest;
import com.barry.cours.app.ws.userservice.UserService;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author algas
 *
 */
@RestController
@RequestMapping(path = "/users")
@Slf4j
@Getter
@Setter

public class UserController {

	private Map<String, UserRest> users;
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	/**
	 * 
	 * @param page
	 * @param limit
	 * @param sort
	 * @return
	 */
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {
		return String.join(" ", "Get users was called with page =", String.valueOf(page),
				"and limit = ", String.valueOf(limit), "and sort =", sort);
	}
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unused")
	@GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		if(true) throw new UserServiceException("A user service  exeception thrown");
		if(users.containsKey(userId)) {
			return  new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		}
		return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		

	}
	@PostMapping(path = "/save",
			consumes = {
					  MediaType.APPLICATION_XML_VALUE, 
					  MediaType.APPLICATION_JSON_VALUE
					},
			produces =
		{
		  MediaType.APPLICATION_XML_VALUE, 
		  MediaType.APPLICATION_JSON_VALUE
		})
	/**
	 * 
	 * @param detailsRequest
	 * @return
	 */
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest detailsRequest) {
	
		return new ResponseEntity<>(userService.createUser(detailsRequest), HttpStatus.OK);
	}
	@PutMapping(path = "/update/{userId}")
	/**
	 * 
	 * @return
	 */
	public ResponseEntity<UserRest> updateUser(@Valid @RequestBody UserModelRequestDetailsModel detailsModel, @PathVariable String userId) {
		
		UserRest user = users.get(userId);
		user.setFirstName(detailsModel.getFirstName());
		user.setLastName(detailsModel.getLastName());
		users.put(user.getUserId(), user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	/**
	 * 
	 * @return
	 */
	@DeleteMapping("/delete/{userId}")
	ResponseEntity<?> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
