package com.seismaismais.praiser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.praiser.dao.SlideDao;
import com.seismaismais.praiser.model.Slide;
import com.seismaismais.praiser.service.SlideService;

@Service("slideService")
@Transactional
public class SlideServiceImpl implements SlideService{

	@Autowired
	private SlideDao slideDAO;

	public Slide findById(Long id) {
		return slideDAO.findById(id);
	}
	
	public Slide findByFilename(String filename) {
		return slideDAO.findByFilename(filename);
	}
	
	public List<Slide> list() {
		return slideDAO.list();
	}

	public void delete(Slide slide) {
		slideDAO.delete(slide);
	}

	public void create(Slide slide) {
		slideDAO.create(slide);
	}
	
	public void update(Slide slide) {
		slideDAO.update(slide);
	}
}