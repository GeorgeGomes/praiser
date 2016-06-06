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

import com.seismaismais.praiser.model.Background;
import com.seismaismais.praiser.service.BackgroundService;
import com.seismaismais.praiser.util.FileUtil;

@RestController
@PropertySource(value = { "classpath:app.properties" })
public class BackgroundRestController {

	Logger logger = Logger.getLogger(BackgroundRestController.class);

	 @Autowired
	 private Environment environment;
	
	@Autowired
	private BackgroundService backgroundService;

	@RequestMapping(value = "/rest/admin/background/list", method = RequestMethod.GET)
	public ResponseEntity<List<Background>> list() {
		List<Background> backgrounds = backgroundService.list();
		if (backgrounds.isEmpty()) {
			return new ResponseEntity<List<Background>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Background>>(backgrounds, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/admin/background/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Background> get(@PathVariable("id") long id) {
		Background backgroundAuth = backgroundService.findById(id);

		if (backgroundAuth == null) {
			return new ResponseEntity<Background>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Background>(backgroundAuth, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/admin/background/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Background> create(@RequestBody Background background) {
		backgroundService.create(background);
		
//		String filename = "[]";
//		try {
//			filename = "{\"filename\":\"" + downloadService.generatePptx(background) + "\"}";
//		} catch (IOException e) {
//			logger.error("Erro",e);
//		}
		
		return new ResponseEntity<Background>(background, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/rest/admin/background/update", method = RequestMethod.PUT)
	public ResponseEntity<Background> update(@RequestBody Background background) {
		backgroundService.update(background);
		return new ResponseEntity<Background>(background, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/admin/background/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Background> delete(@PathVariable("id") long id) {
		Background background = backgroundService.findById(id);
		backgroundService.delete(background);
		return new ResponseEntity<Background>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/rest/admin/background/upload/{id}", method = RequestMethod.POST)
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
				
				Background background = backgroundService.findById(id);
				background.setFilename(filename);
				backgroundService.update(background);
				
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