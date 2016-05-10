package com.seismaismais.stronger.service;

import java.util.List;

import com.seismaismais.stronger.model.MuscleGroup;

public interface MuscleGroupService {
	public List<MuscleGroup> list();
	public MuscleGroup get(Long id);
	public void delete(MuscleGroup muscleGroup);
	public void update(MuscleGroup muscleGroup);
	public void create(MuscleGroup muscleGroup);
	
}
