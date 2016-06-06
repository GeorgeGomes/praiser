package com.seismaismais.praiser.service;

import java.util.List;

import com.seismaismais.praiser.model.Background;

public interface BackgroundService {

	public Background findById(Long id);
	public Background findByFilename(String filename);
	public List<Background> list();
	public void delete(Background background);
	public void update(Background background);
	public void create(Background background);
	
}