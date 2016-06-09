package com.seismaismais.praiser.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seismaismais.praiser.model.Slide;
import com.seismaismais.praiser.service.SlideService;

@Controller
public class DownloadController {

	Logger logger = Logger.getLogger(DownloadController.class);

	@Autowired
	private SlideService slideService;
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String getSlides() {
		return "/download";
	}

	@RequestMapping(value = "/download/{filename}", method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getDownloadData(@PathVariable String filename)
	 throws Exception {
	 Slide slide = slideService.findByFilename(filename);
	
	 FileInputStream pptFile = new FileInputStream("/praiser/" + slide.getFilename() + ".pptx");
	 
	 byte[] output = IOUtils.toByteArray(pptFile);
			 
	 HttpHeaders responseHeaders = new HttpHeaders();
	 responseHeaders.set("charset", "utf-8");
	 responseHeaders.setContentType(
	 MediaType.valueOf("application/vnd.openxmlformats-officedocument.presentationml.presentation"));
	 responseHeaders.setContentLength(output.length);
	 responseHeaders.set("Content-disposition", "attachment;filename=MeuPraiser.pptx");
	
	 return new ResponseEntity<byte[]>(output, responseHeaders,
	 HttpStatus.OK);
	 }

}