package com.seismaismais.stronger.service;

import java.util.List;

import com.seismaismais.stronger.model.Exercise;

public interface ExerciseService {
	public List<Exercise> list();
	public Exercise get(Long id);
	public void delete(Exercise exercise);
	public void update(Exercise exercise);
	public void create(Exercise exercise);
	
}
