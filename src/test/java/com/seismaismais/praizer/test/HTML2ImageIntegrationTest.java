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
		String html = "<html><head></head><body><div style='background-color:#000000;max-width: 62em; margin: 0 auto;color:#ffffff;font-size:1.5em;text-align:center'><span style=';font-weight:bold'>For Him and you</span> <img src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAQAAAAAYLlVAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAAmJLR0QAAKqNIzIAAAAJcEhZcwAADdcAAA3XAUIom3gAAAAHdElNRQfgBRsTJSEvkjNcAAAChUlEQVRo3u2YTUhUURiGnzszmZlgVIs0CKeiSYJGZ0TaFe2CoqCNLcpNhBK0CFoUhAVtWgQto5UQBNVCMfctbOnIIOLQD/ZDC4t+jUxHm7eFo850de5P5zqb+87m3jPfd97ncO/5zj3HEtVVpMr+IUAIEAKEACEAMWM9RYmTIMEuvvOR1wwz6ypPJn4pDSivcv3SoI455/6/ebsGtbae61CwANfkpHldCg6g19F+UfeDAbjl0l6SrpsHOOPBXiro1Or9WC4/yTZwgAITLCxP3xx7PU3T9+xjzs80jOmqMpqTJM1qRBdlCV3wNP5FXfbzCA4qY+toWEl98AHwzjtAR3Hk9ifqT612j0prQS191Kz6j+WzXB+3N1UCuEmLT6O1tN8bwHnD9tDoBaCZrcYBtnkBSBm3hykvAA0BALzxAjAZAMBbe1P5F1GUFtKkSZJnJgCAThYY4kVZW0lROKxJnwXGm16p214JN+mu7/pm15gWHCIeqr4UoEE5gyPsFGpzjJpQfAWgz6B9XlEhNOEY+WxpLThBl8EXrcAfAPKOkUfoAktbyLHDIMActQBkSTrGfiYR4ahRe2/azskI6arZAyRjRgGekKW7eD3DHQr0UF8ZAH0y9v6PyxJKFCvLblc7hy8Rfhsbfx2C5UK7uJbUO+T8jDBiDCDOlX9aWulxyBk1CQC3OV1y18QQmx0yMmYBLB7QUbyu4yk7HTNG0UaNGyzE0pSahSLqdxE7phqEUpo3ivBD91wtbnm1LS1GN4wCuFXvymoY08C62/crVr41O6dv62b+VWdX2xs26dE6QEzrsRornQ/soZ1UIB/l02TJ8JIyS7cHFIGp6ielIUAIEAKEACHAX5wkdij7D0ypAAAAJXRFWHRkYXRlOmNyZWF0ZQAyMDE2LTA1LTI3VDE5OjM3OjMzKzAyOjAwaw2jVAAAACV0RVh0ZGF0ZTptb2RpZnkAMjAxNi0wNS0yN1QxOTozNzozMyswMjowMBpQG+gAAAAZdEVYdFNvZnR3YXJlAHd3dy5pbmtzY2FwZS5vcmeb7jwaAAAAAElFTkSuQmCC' alt=''> powered by <img src='http://10.10.6.125:8090/praizer/static/img/logo-twhp.png' width='60'></div></body></html>";		
		
		HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
//		imageGenerator.loadHtml(
//				"<b>Hello World!</b> Please goto <a title=\"Goto Google\" href=\"http://www.google.com\">Google</a>.");
		imageGenerator.loadHtml(html);
		
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
