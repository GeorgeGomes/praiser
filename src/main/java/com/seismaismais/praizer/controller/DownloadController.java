package com.seismaismais.praizer.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seismaismais.praizer.model.Slide;
import com.seismaismais.praizer.service.SlideService;

import gui.ava.html.image.generator.HtmlImageGenerator;

@Controller
public class DownloadController {

	Logger logger = Logger.getLogger(DownloadController.class);

	@Autowired
	private SlideService slideService;

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String getSlides() {
		return "/download";
	}

	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getDownloadData(@PathVariable long id) throws Exception {
		Slide slide = slideService.findById(id);

		List<byte[]> imagesList = generateImage(slide.getSlide());
		byte[] output = generatePptx(imagesList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("charset", "utf-8");
		responseHeaders.setContentType(
				MediaType.valueOf("application/vnd.openxmlformats-officedocument.presentationml.presentation"));
		responseHeaders.setContentLength(output.length);
		responseHeaders.set("Content-disposition", "attachment; filename=MeuPraiser.pptx");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}

	public byte[] generatePptx(List<byte[]> imagesList) throws IOException {
		XMLSlideShow ppt = new XMLSlideShow();

		Iterator<byte[]> imagesIterator = imagesList.iterator();

		while (imagesIterator.hasNext()) {
			byte[] image = imagesIterator.next();
			XSLFSlide slide = ppt.createSlide();
			XSLFPictureData pd = ppt.addPicture(image, PictureData.PictureType.JPEG);
			slide.createPicture(pd);
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ppt.write(out);
		ppt.close();
		return out.toByteArray();

	}

	public List<byte[]> generateImage(String htmlSlides) {
		List<byte[]> imagesList = new ArrayList<byte[]>();
		htmlSlides = StringEscapeUtils.unescapeHtml4(htmlSlides);
		Document doc = Jsoup.parse(htmlSlides);
		Elements divs = doc.getElementsByAttributeValue("name", "slide");

		for (Element div : divs) {
			HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
			imageGenerator.loadHtml(div.html());
			imagesList.add(getBytes(imageGenerator.getBufferedImage()));
		}

		return imagesList;
	}

	public static void write(BufferedImage image, OutputStream out) throws IOException {
		Iterator writers = ImageIO.getImageWritersBySuffix("jpeg");
		if (!writers.hasNext())
			throw new IllegalStateException("No writers found");
		ImageWriter writer = (ImageWriter) writers.next();
		ImageOutputStream ios = ImageIO.createImageOutputStream(out);
		writer.setOutput(ios);
		ImageWriteParam param = writer.getDefaultWriteParam();
		// if (quality >= 0) {
		param.setCompressionMode(ImageWriteParam.MODE_DEFAULT);
		// param.setCompressionQuality(quality);
		// }
		writer.write(null, new IIOImage(image, null, null), param);
	}

	public static BufferedImage read(byte[] bytes) {
		try {
			return ImageIO.read(new ByteArrayInputStream(bytes));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] getBytes(BufferedImage image) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream(50000);
			write(image, out);
			return out.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static BufferedImage compress(BufferedImage image) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			write(image, out);
			return ImageIO.read(new ByteArrayInputStream(out.toByteArray()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}