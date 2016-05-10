package com.seismaismais.stronger.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.seismaismais.stronger.model.User;
import com.seismaismais.stronger.service.UserService;



@RestController
public class UserRestController{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/rest/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> list(){
		List<User> users = userService.list();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new  ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/user/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> get(@PathVariable("id") long id){
		User user = userService.get(id);
		if(user == null){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/user/", method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody User user, UriComponentsBuilder ucBuilder){		
		userService.create(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/rest/user/{id}").buildAndExpand(user.getCodUser()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/rest/user/", method=RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user){
		userService.update(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/user/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable("id") long id){
		User user = userService.get(id);
		userService.delete(user);		
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
}