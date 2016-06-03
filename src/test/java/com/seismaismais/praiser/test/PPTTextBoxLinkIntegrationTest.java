package com.seismaismais.praiser.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFHyperlink;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.junit.Test;

public class PPTTextBoxLinkIntegrationTest {

	@Test
	public void test() throws IOException {

		XMLSlideShow ppt = new XMLSlideShow();

        XSLFSlide slide1 = ppt.createSlide();
        XSLFSlide slide2 = ppt.createSlide();

    	XSLFPictureData pd = ppt.addPicture(getBytes(gerarImagem()), PictureData.PictureType.JPEG);
		slide1.createPicture(pd);
        
        XSLFTextBox shape1 = slide1.createTextBox();
        shape1.setAnchor(new Rectangle(50, 50, 200, 50));
        XSLFTextRun r1 = shape1.addNewTextParagraph().addNewTextRun();
        XSLFHyperlink link1 = r1.createHyperlink();
        r1.setText("Texto"); // visible text
        link1.setAddress("http://poi.apache.org");  // link address

        XSLFTextBox shape2 = slide1.createTextBox();
        shape2.setAnchor(new Rectangle(300, 50, 200, 50));
        XSLFTextRun r2 = shape2.addNewTextParagraph().addNewTextRun();
        XSLFHyperlink link2 = r2.createHyperlink();
        r2.setText("Go to the second slide"); // visible text
        link2.linkToSlide(slide2);  // link address

        FileOutputStream out = new FileOutputStream("/Users/georgeg/Desktop/praizer/power.pptx");
        ppt.write(out);
        out.close();
        ppt.close();
		
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
	  //  if (quality >= 0) {
	        param.setCompressionMode(ImageWriteParam.MODE_DEFAULT );
	        //param.setCompressionQuality(quality);
	   // }
	    writer.write(null, new IIOImage(image, null, null), param);
	}
	public static BufferedImage read(byte[] bytes) {
	    try {
	        return ImageIO.read(new ByteArrayInputStream(bytes));
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	public static byte[] getBytes(BufferedImage image) {
	    try {
	        ByteArrayOutputStream out = new ByteArrayOutputStream(50000);
	        write(image, out);
	        return out.toByteArray();
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	public static BufferedImage compress(BufferedImage image) {
	    try {
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        write(image, out);
	        return ImageIO.read(new ByteArrayInputStream(out.toByteArray()));
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	
}
