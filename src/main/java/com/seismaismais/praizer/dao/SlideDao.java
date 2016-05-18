package com.seismaismais.praizer.dao;

import java.util.List;

import com.seismaismais.praizer.model.Slide;

public interface SlideDao {
	public Slide findById(Long id);
	public void create(Slide slide); 
	public void update(Slide slide);
	public void delete(Slide slide);
	public List<Slide> list();
	
}

