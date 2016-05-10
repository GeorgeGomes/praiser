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

import com.seismaismais.stronger.model.MuscleGroup;
import com.seismaismais.stronger.service.MuscleGroupService;



@RestController
public class MuscleGroupRestController{

	@Autowired
	private MuscleGroupService muscleGroupService;
	
	@RequestMapping(value="/rest/muscleGroup/", method = RequestMethod.GET)
	public ResponseEntity<List<MuscleGroup>> list(){
		List<MuscleGroup> muscleGroups = muscleGroupService.list();
		if(muscleGroups.isEmpty()){
			return new ResponseEntity<List<MuscleGroup>>(HttpStatus.NO_CONTENT);
		}
		return new  ResponseEntity<List<MuscleGroup>>(muscleGroups, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/muscleGroup/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MuscleGroup> get(@PathVariable("id") long id){
		MuscleGroup muscleGroup = muscleGroupService.get(id);
		if(muscleGroup == null){
			return new ResponseEntity<MuscleGroup>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MuscleGroup>(muscleGroup, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/muscleGroup/", method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody MuscleGroup muscleGroup, UriComponentsBuilder ucBuilder){		
		muscleGroupService.create(muscleGroup);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/rest/muscleGroup/{id}").buildAndExpand(muscleGroup.getCodMuscleGroup()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/rest/muscleGroup/", method=RequestMethod.PUT)
	public ResponseEntity<MuscleGroup> update(@RequestBody MuscleGroup muscleGroup){
		muscleGroupService.update(muscleGroup);
		return new ResponseEntity<MuscleGroup>(muscleGroup, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/muscleGroup/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<MuscleGroup> delete(@PathVariable("id") long id){
		MuscleGroup muscleGroup = muscleGroupService.get(id);
		muscleGroupService.delete(muscleGroup);		
		return new ResponseEntity<MuscleGroup>(HttpStatus.NO_CONTENT);
	}
	
}