package com.seismaismais.stronger.dao;

import java.util.List;

import com.seismaismais.stronger.model.MuscleGroup;

public interface MuscleGroupDAO {
	public void create(MuscleGroup MuscleGroup); 
	public void update(MuscleGroup MuscleGroup);
	public void delete(MuscleGroup MuscleGroup);
	public MuscleGroup get(Long id); 
	public List<MuscleGroup> list();
}