package com.seismaismais.praiser.dao;

import java.util.List;

import com.seismaismais.praiser.model.Slide;

public interface SlideDao {
	public Slide findById(Long id);
	public Slide findByFilename(String filename);
	public void create(Slide slide); 
	public void update(Slide slide);
	public void delete(Slide slide);
	public List<Slide> list();
	
}

