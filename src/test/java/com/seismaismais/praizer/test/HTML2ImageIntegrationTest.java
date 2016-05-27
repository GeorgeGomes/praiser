package com.seismaismais.praizer.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.junit.Test;

import gui.ava.html.image.generator.HtmlImageGenerator;

public class HTML2ImageIntegrationTest {

	@Test
	public void test() throws IOException {

//		String html = getUrlSource("http://10.10.6.125:8090/praizer/");
String html = "<div style='width:50px;height:50px;border:1px solid red'>oi</div>";
		
		
		HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
//		imageGenerator.loadHtml(
//				"<b>Hello World!</b> Please goto <a title=\"Goto Google\" href=\"http://www.google.com\">Google</a>.");
		imageGenerator.loadHtml(html);
		Dimension d = new Dimension();
		d.setSize(200, 100);
		imageGenerator.setSize(d);
		imageGenerator.saveAsImage("/Users/georgeg/Desktop/praizer/hello-world.png");
		
		//imageGenerator.saveAsHtmlWithMap("hello-world.html", "hello-world.png");
	}

	private static String getUrlSource(String url) throws IOException {
		URL yahoo = new URL(url);
		URLConnection yc = yahoo.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuilder a = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			a.append(inputLine);
		in.close();

		return a.toString();
	}

	public BufferedImage gerarImagem() {
		BufferedImage img = new BufferedImage(946, 718, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = img.createGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		g.dispose();

		return img;
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
