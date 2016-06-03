package com.seismaismais.praiser.test;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLEditorKit;

import org.junit.Test;

public class TestClass {

	private static ImageCache image_cache;

	@Test
	public void main() throws IOException {
		URL img_url = null;
		image_cache = new ImageCache();

		try {
			// img_url = new
			// File("C:/Users/georgeg/Desktop/logo-sama.png").toURI().toURL();
			img_url = new URL("http://10.10.6.125:8090/praizer/static/img/ibab-louvor.png");

			Image img = Toolkit.getDefaultToolkit().createImage(img_url);
			image_cache.put(img_url, img);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String html = "<html>" + "<body>" + "<img src=\"" + img_url.toString() + "\">" + "</body>" + "</html>";

		JEditorPane swingbox = new JEditorPane();
		swingbox.setEditorKit(new HTMLEditorKit());
		swingbox.setContentType("text/html");
		swingbox.setText(html);

		JFrame frame = new JFrame("Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(swingbox);

		Dictionary cache = (Dictionary) swingbox.getDocument().getProperty("imageCache");

		// put the cache if it is not present. it should be null in the
		// beginning
		if (cache == null) {
			swingbox.getDocument().putProperty("imageCache", image_cache);
		}

		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);


	}

	static class ImageCache extends Hashtable {

		public Object get(Object key) {

			Object result = super.get(key);

			if (result == null) {
				result = Toolkit.getDefaultToolkit().createImage((URL) key);
				put(key, result);
			}

			return result;
		}
	}

}