package com.seismaismais.praiser.rest.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.seismaismais.praiser.auth.model.User;
import com.seismaismais.praiser.model.Font;
import com.seismaismais.praiser.service.DownloadService;
import com.seismaismais.praiser.service.FontService;
import com.seismaismais.praiser.util.FileUtil;

@RestController
@PropertySource(value = { "classpath:app.properties" })
public class FontRestController {

	Logger logger = Logger.getLogger(FontRestController.class);

	 @Autowired
	 private Environment environment;
	
	@Autowired
	private FontService fontService;

	@RequestMapping(value = "/rest/admin/font/list", method = RequestMethod.GET)
	public ResponseEntity<List<Font>> list() {
		List<Font> fonts = fontService.list();
		if (fonts.isEmpty()) {
			return new ResponseEntity<List<Font>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Font>>(fonts, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/admin/font/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Font> get(@PathVariable("id") long id) {
		Font fontAuth = fontService.findById(id);

		if (fontAuth == null) {
			return new ResponseEntity<Font>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Font>(fontAuth, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/admin/font/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Font> create(@RequestBody Font font) {
		fontService.create(font);
		
//		String filename = "[]";
//		try {
//			filename = "{\"filename\":\"" + downloadService.generatePptx(font) + "\"}";
//		} catch (IOException e) {
//			logger.error("Erro",e);
//		}
		
		return new ResponseEntity<Font>(font, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/rest/admin/font/update", method = RequestMethod.PUT)
	public ResponseEntity<Font> update(@RequestBody Font font) {
		fontService.update(font);
		return new ResponseEntity<Font>(font, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/admin/font/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Font> delete(@PathVariable("id") long id) {
		Font font = fontService.findById(id);
		fontService.delete(font);
		return new ResponseEntity<Font>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/rest/admin/font/upload/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> upload(@PathVariable("id") long id, @RequestParam("file") MultipartFile file) {
		
		if (!file.isEmpty()) {
			try {
				//String type = file.getContentType().split("/")[1];
				String type = file.getOriginalFilename().split("\\.")[1];
				String filename = FileUtil.generateUniqueFileName() + '.' + type;
				//User userAuth = authenticateService.getUserRequest();
				
				//userAuth.setImagemProfile(name);
				
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(environment.getRequiredProperty("app.archive.upload.admin") + filename)));
				stream.write(bytes);
				stream.close();
				
				Font font = fontService.findById(id);
				font.setFilename(filename);
				fontService.update(font);
				
				//userService.update(userAuth);
				//authenticateService.saveUserRequest(userAuth);
				
			} catch (Exception e) {
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}