package com.seismaismais.stronger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seismaismais.stronger.dao.MuscleGroupDAO;
import com.seismaismais.stronger.model.MuscleGroup;
import com.seismaismais.stronger.service.MuscleGroupService;


@Service("muscleGroupService")
public class MuscleGroupServiceImpl implements MuscleGroupService{
	
	@Autowired
	private MuscleGroupDAO muscleGroupDAO;

	public List<MuscleGroup> list() {
		return muscleGroupDAO.list();
	}

	public MuscleGroup get(Long id) {
		return muscleGroupDAO.get(id);
	}

	public void delete(MuscleGroup muscleGroup) {
		muscleGroupDAO.delete(muscleGroup);
	}

	public void create(MuscleGroup muscleGroup) {
		muscleGroupDAO.create(muscleGroup);
	}
	
	public void update(MuscleGroup muscleGroup) {
		muscleGroupDAO.update(muscleGroup);
	}

}