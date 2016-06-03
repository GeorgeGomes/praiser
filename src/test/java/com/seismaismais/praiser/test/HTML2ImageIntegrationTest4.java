package com.seismaismais.praiser.test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLEditorKit;

import org.junit.Test;

import com.seismaismais.praiser.test.TestClass.ImageCache;

public class HTML2ImageIntegrationTest4 {

	private static ImageCache image_cache;
	
	@Test
	public void test() throws IOException {
		
		    int width = 1000, height = 500;
		    
		    image_cache = new ImageCache();
		    
		    URL img_url = new URL("http://10.10.6.125:8090/praizer/static/img/logo-twhp.png");
        	
            Image img = Toolkit.getDefaultToolkit ().createImage (img_url); 
            image_cache.put(img_url, img);
		    
            String html = "<html><head></head><body><div style='background-color:#000000;max-width: 62em; margin: 0 auto;color:#ffffff;font-size:1.5em;text-align:center'><span style=';font-weight:bold'>For Him and you</span> powered by <img src='"+img_url.toString()+"'></div></body></html>";
            
		    BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
		        .getDefaultScreenDevice().getDefaultConfiguration()
		        .createCompatibleImage(width, height);

		    Graphics2D graphics = image.createGraphics();
		    
		    JEditorPane  swingbox = new JEditorPane ();
	        swingbox.setEditorKit(new HTMLEditorKit());
	        swingbox.setContentType("text/html");
	        swingbox.setText(html);

	        Dictionary cache=(Dictionary)swingbox.getDocument().getProperty("imageCache");

	        // put the cache if it is not present. it should be null in the beginning
	        if (cache==null) {
	            swingbox.getDocument().putProperty("imageCache",image_cache);
	        }

		    
	        swingbox.setSize(width, height);
	        swingbox.print(graphics);
	        

		    ImageIO.write(image, "png", new File("/Users/georgeg/Desktop/praizer/hello-world2.png"));
	}

    static class ImageCache extends Hashtable {

        public Object get(Object key) {

            Object result = super.get(key);

            if (result == null){
                result = Toolkit.getDefaultToolkit().createImage((URL) key);
                put(key, result);
            }

            return result;
        }
    }
}
