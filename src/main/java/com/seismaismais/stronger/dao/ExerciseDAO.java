package com.seismaismais.stronger.dao;

import java.util.List;

import com.seismaismais.stronger.model.Exercise;

public interface ExerciseDAO {
	public void create(Exercise Exercise); 
	public void update(Exercise Exercise);
	public void delete(Exercise Exercise);
	public Exercise get(Long id); 
	public List<Exercise> list();
}