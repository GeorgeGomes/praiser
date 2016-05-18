package com.seismaismais.praizer.service;

import java.util.List;

import com.seismaismais.praizer.model.Slide;

public interface SlideService {

	public Slide findById(Long id);
	public List<Slide> list();
	public void delete(Slide slide);
	public void update(Slide slide);
	public void create(Slide slide);
	
}