package com.seismaismais.praiser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.praiser.dao.BackgroundDao;
import com.seismaismais.praiser.model.Background;
import com.seismaismais.praiser.service.BackgroundService;

@Service("backgroundService")
@Transactional
public class BackgroundServiceImpl implements BackgroundService{

	@Autowired
	private BackgroundDao backgroundDAO;

	public Background findById(Long id) {
		return backgroundDAO.findById(id);
	}
	
	public Background findByFilename(String filename) {
		return backgroundDAO.findByFilename(filename);
	}
	
	public List<Background> list() {
		return backgroundDAO.list();
	}

	public void delete(Background background) {
		backgroundDAO.delete(background);
	}

	public void create(Background background) {
		backgroundDAO.create(background);
	}
	
	public void update(Background background) {
		backgroundDAO.update(background);
	}
}