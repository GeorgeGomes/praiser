package com.seismaismais.praiser.service;

import java.util.List;

import com.seismaismais.praiser.model.Slide;

public interface SlideService {

	public Slide findById(Long id);
	public Slide findByFilename(String filename);
	public List<Slide> list();
	public void delete(Slide slide);
	public void update(Slide slide);
	public void create(Slide slide);
	
}