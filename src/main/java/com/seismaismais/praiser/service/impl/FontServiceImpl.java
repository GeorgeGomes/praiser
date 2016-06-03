package com.seismaismais.praiser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.praiser.dao.FontDao;
import com.seismaismais.praiser.model.Font;
import com.seismaismais.praiser.service.FontService;

@Service("fontService")
@Transactional
public class FontServiceImpl implements FontService{

	@Autowired
	private FontDao fontDAO;

	public Font findById(Long id) {
		return fontDAO.findById(id);
	}
	
	public Font findByFilename(String filename) {
		return fontDAO.findByFilename(filename);
	}
	
	public List<Font> list() {
		return fontDAO.list();
	}

	public void delete(Font font) {
		fontDAO.delete(font);
	}

	public void create(Font font) {
		fontDAO.create(font);
	}
	
	public void update(Font font) {
		fontDAO.update(font);
	}
}