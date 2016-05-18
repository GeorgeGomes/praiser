package com.seismaismais.praizer.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.praizer.dao.SlideDao;
import com.seismaismais.praizer.model.Slide;
import com.seismaismais.praizer.service.SlideService;

@Service("slideService")
@Transactional
public class SlideServiceImpl implements SlideService{

	@Autowired
	private SlideDao slideDAO;

	public Slide findById(Long id) {
		return slideDAO.findById(id);
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