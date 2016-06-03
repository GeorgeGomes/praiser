package com.seismaismais.praiser.dao;

import java.util.List;

import com.seismaismais.praiser.model.Font;

public interface FontDao {
	public Font findById(Long id);
	public Font findByFilename(String filename);
	public void create(Font font); 
	public void update(Font font);
	public void delete(Font font);
	public List<Font> list();
	
}

