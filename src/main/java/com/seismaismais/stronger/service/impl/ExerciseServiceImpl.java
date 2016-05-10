package com.seismaismais.stronger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seismaismais.stronger.dao.ExerciseDAO;
import com.seismaismais.stronger.model.Exercise;
import com.seismaismais.stronger.service.ExerciseService;


@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService{
	
	@Autowired
	private ExerciseDAO exerciseDAO;

	public List<Exercise> list() {
		return exerciseDAO.list();
	}

	public Exercise get(Long id) {
		return exerciseDAO.get(id);
	}

	public void delete(Exercise exercise) {
		exerciseDAO.delete(exercise);
	}

	public void create(Exercise exercise) {
		exerciseDAO.create(exercise);
	}
	
	public void update(Exercise exercise) {
		exerciseDAO.update(exercise);
	}

}