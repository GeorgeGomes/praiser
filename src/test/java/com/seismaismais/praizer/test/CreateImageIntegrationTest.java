package com.seismaismais.praizer.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.junit.Test;

public class CreateImageIntegrationTest {

	@Test
	public void test() throws IOException {

		byte[] b = getBytes(gerarImagem());

		File outputfile = new File("/Users/georgeg/Desktop/praizer/image.jpg");
		ImageIO.write(gerarImagem(), "jpg", outputfile);

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
