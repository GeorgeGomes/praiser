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

import com.seismaismais.stronger.model.Exercise;
import com.seismaismais.stronger.service.ExerciseService;



@RestController
public class ExerciseRestController{

	@Autowired
	private ExerciseService exerciseService;
	
	@RequestMapping(value="/rest/exercise/", method = RequestMethod.GET)
	public ResponseEntity<List<Exercise>> list(){
		List<Exercise> exercises = exerciseService.list();
		if(exercises.isEmpty()){
			return new ResponseEntity<List<Exercise>>(HttpStatus.NO_CONTENT);
		}
		return new  ResponseEntity<List<Exercise>>(exercises, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/exercise/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Exercise> get(@PathVariable("id") long id){
		Exercise exercise = exerciseService.get(id);
		if(exercise == null){
			return new ResponseEntity<Exercise>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Exercise>(exercise, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/exercise/", method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Exercise exercise, UriComponentsBuilder ucBuilder){		
		exerciseService.create(exercise);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/rest/exercise/{id}").buildAndExpand(exercise.getCodExercise()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/rest/exercise/", method=RequestMethod.PUT)
	public ResponseEntity<Exercise> update(@RequestBody Exercise exercise){
		exerciseService.update(exercise);
		return new ResponseEntity<Exercise>(exercise, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/exercise/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Exercise> delete(@PathVariable("id") long id){
		Exercise exercise = exerciseService.get(id);
		exerciseService.delete(exercise);		
		return new ResponseEntity<Exercise>(HttpStatus.NO_CONTENT);
	}
	
}