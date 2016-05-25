package com.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.junit.Test;

public class PPTLayoutIntegrationTest {

	@Test
	public void test() throws IOException {

		// creating presentation
		XMLSlideShow ppt = new XMLSlideShow();

		// getting the slide master object
		XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0);
		
		XSLFSlideLayout slideLayout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);

		//Slide #1
		XSLFSlide slide1 = ppt.createSlide(slideLayout);

		XSLFTextShape title = slide1.getPlaceholder(0);
		title.setText("Nome da musica");
		XSLFTextShape body = slide1.getPlaceholder(1);
		body.clearText();
		XSLFTextParagraph text = body.addNewTextParagraph();
		text.setBullet(false);
		text.addNewTextRun().setText("Music aaquii");
		
		//Slide #2
		XSLFSlide slide2 = ppt.createSlide(slideLayout);
		

		XSLFTextShape title2 = slide2.getPlaceholder(0);
		XSLFTextShape body2 = slide2.getPlaceholder(1);
		
		
		slide2.removeShape(title2);
		body2.clearText();
		
		XSLFTextParagraph text2 = body2.addNewTextParagraph();
		text2.setBullet(false);
		text2.addNewTextRun().setText("Refrão 2");
	
		File file = new File("/Users/georgeg/Desktop/praizer/power1.pptx");
		FileOutputStream out = new FileOutputStream(file);

		ppt.write(out);
		out.close();
		ppt.close();
	}
	
}
