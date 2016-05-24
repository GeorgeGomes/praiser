package com.test;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.Fill;
import org.apache.poi.hslf.model.SlideMaster;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.junit.Test;

public class CreatePowerPointIntegrationTest2 {

	@Test
	public void test() throws IOException {

		HSLFSlideShow ppt = HSLFSlideShow.create(); 
        SlideShow presentation = new SlideShow(ppt); 
        SlideMaster[] sm = presentation.getSlidesMasters();
        SlideMaster m = sm[0];
        Fill f = m.getBackground().getFill();
        f.setBackgroundColor(Color.BLACK);
        
	    //save changes in a file
		
		File file = new File("/Users/georgeg/Desktop/praizer/power.pptx");
		FileOutputStream out = new FileOutputStream(file);

		ppt.write(out);
		out.close();
	}

}
