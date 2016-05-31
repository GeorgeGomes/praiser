package com.seismaismais.praizer.test;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import org.junit.Test;

public class HTML2ImageIntegrationTest2 {

	@Test
	public void test() throws IOException {
		BufferedImage ire;
		ire = create("file:///C:/Users/georgeg/Desktop/12.html", 1024, 500);
		ImageIO.write(ire, "jpg", new File("/Users/georgeg/Desktop/praizer/hello-world1.png"));
	}

	static class Kit extends HTMLEditorKit {
		public Document createDefaultDocument() {
			HTMLDocument doc = (HTMLDocument) super.createDefaultDocument();
			doc.setTokenThreshold(Integer.MAX_VALUE);
			doc.setAsynchronousLoadPriority(-1);
			return doc;
		}
	}

	public static BufferedImage create(String src, int width, int height) {
		BufferedImage image = null;
		JEditorPane pane = new JEditorPane();
		Kit kit = new Kit();
		pane.setEditorKit(kit);
		pane.setEditable(false);
		pane.setMargin(new Insets(0, 0, 0, 0));
		try {
			pane.setPage(src);
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			Container c = new Container();
			SwingUtilities.paintComponent(g, pane, c, 0, 0, width, height);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e);
		}
		return image;
	}

	public static void main(String[] args) throws IOException {

	}

}
