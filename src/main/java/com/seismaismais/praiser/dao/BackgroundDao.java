package com.seismaismais.praiser.dao;

import java.util.List;

import com.seismaismais.praiser.model.Background;

public interface BackgroundDao {
	public Background findById(Long id);
	public Background findByFilename(String filename);
	public void create(Background background); 
	public void update(Background background);
	public void delete(Background background);
	public List<Background> list();
	
}

