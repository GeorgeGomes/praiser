package com.seismaismais.praiser.auth.rest.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.seismaismais.praiser.auth.model.User;
import com.seismaismais.praiser.auth.model.UserProfile;
import com.seismaismais.praiser.auth.service.AuthenticateService;
import com.seismaismais.praiser.auth.service.UserService;
import com.seismaismais.praiser.util.FileUtil;

@RestController
public class UserRestController {

	Logger logger = Logger.getLogger(UserRestController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticateService authenticateService;

	@RequestMapping(value = "/rest/auth/user/list", method = RequestMethod.GET)
	public ResponseEntity<List<User>> list() {
		List<User> users = userService.list();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/auth/user/uniqueEmail", method = RequestMethod.POST)
	public ResponseEntity<Boolean> uniqueEmail(@RequestBody String email) {
		Boolean emailExists = false;
		
		if(userService.findByEmail(email) != null){
			emailExists = true;
		}
		
		return new ResponseEntity<Boolean>(emailExists, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rest/auth/user/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> get() {
		User userAuth = authenticateService.getUserRequest();

		if (userAuth == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(userAuth, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/auth/user/create", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		UserProfile userProfile = new UserProfile();
		userProfile.setId(2);
		userProfile.setType("USER");

		Set<UserProfile> userProfiles = new HashSet<UserProfile>();
		userProfiles.add(userProfile);
		user.setUserProfiles(userProfiles);

		userService.create(user);

		User userAuth = authenticateService.authenticate(user.getEmail(), user.getPassword());
		authenticateService.saveUserRequest(userAuth);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/rest/user/{id}").buildAndExpand(user.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/rest/auth/user/update", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user) {
		userService.update(user);
		authenticateService.saveUserRequest(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/auth/user/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable("id") long id) {
		User user = userService.findById(id);
		userService.delete(user);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/rest/auth/user/upload", method = RequestMethod.POST)
	public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				String type = file.getContentType().split("/")[1];
				String name = FileUtil.generateUniqueFileName() + '.' + type;
				User userAuth = authenticateService.getUserRequest();
				
				userAuth.setImagemProfile(name);
				
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("/praiser/" + name)));
				stream.write(bytes);
				stream.close();
				
				userService.update(userAuth);
				authenticateService.saveUserRequest(userAuth);
				
			} catch (Exception e) {
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}