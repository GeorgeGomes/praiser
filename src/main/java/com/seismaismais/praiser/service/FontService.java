package com.seismaismais.praiser.service;

import java.util.List;

import com.seismaismais.praiser.model.Font;

public interface FontService {

	public Font findById(Long id);
	public Font findByFilename(String filename);
	public List<Font> list();
	public void delete(Font font);
	public void update(Font font);
	public void create(Font font);
	
}