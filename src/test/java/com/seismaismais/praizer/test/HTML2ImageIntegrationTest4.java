package com.seismaismais.praizer.test;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;

import org.junit.Test;

import com.seismaismais.praizer.test.HTML2ImageIntegrationTest2.Kit;

public class HTML2ImageIntegrationTest4 {

	@Test
	public void test() throws IOException {
		 //String html = "<h1>Hello, world.</h1>";
		String html = "<html><head></head><body><div style='background-color:#000000;max-width: 62em; margin: 0 auto;color:#ffffff;font-size:1.5em;text-align:center'><span style=';font-weight:bold'>For Him and you</span> <img src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAQAAAAAYLlVAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAAmJLR0QAAKqNIzIAAAAJcEhZcwAADdcAAA3XAUIom3gAAAAHdElNRQfgBRsTJSEvkjNcAAAChUlEQVRo3u2YTUhUURiGnzszmZlgVIs0CKeiSYJGZ0TaFe2CoqCNLcpNhBK0CFoUhAVtWgQto5UQBNVCMfctbOnIIOLQD/ZDC4t+jUxHm7eFo850de5P5zqb+87m3jPfd97ncO/5zj3HEtVVpMr+IUAIEAKEACEAMWM9RYmTIMEuvvOR1wwz6ypPJn4pDSivcv3SoI455/6/ebsGtbae61CwANfkpHldCg6g19F+UfeDAbjl0l6SrpsHOOPBXiro1Or9WC4/yTZwgAITLCxP3xx7PU3T9+xjzs80jOmqMpqTJM1qRBdlCV3wNP5FXfbzCA4qY+toWEl98AHwzjtAR3Hk9ifqT612j0prQS191Kz6j+WzXB+3N1UCuEmLT6O1tN8bwHnD9tDoBaCZrcYBtnkBSBm3hykvAA0BALzxAjAZAMBbe1P5F1GUFtKkSZJnJgCAThYY4kVZW0lROKxJnwXGm16p214JN+mu7/pm15gWHCIeqr4UoEE5gyPsFGpzjJpQfAWgz6B9XlEhNOEY+WxpLThBl8EXrcAfAPKOkUfoAktbyLHDIMActQBkSTrGfiYR4ahRe2/azskI6arZAyRjRgGekKW7eD3DHQr0UF8ZAH0y9v6PyxJKFCvLblc7hy8Rfhsbfx2C5UK7uJbUO+T8jDBiDCDOlX9aWulxyBk1CQC3OV1y18QQmx0yMmYBLB7QUbyu4yk7HTNG0UaNGyzE0pSahSLqdxE7phqEUpo3ivBD91wtbnm1LS1GN4wCuFXvymoY08C62/crVr41O6dv62b+VWdX2xs26dE6QEzrsRornQ/soZ1UIB/l02TJ8JIyS7cHFIGp6ielIUAIEAKEACHAX5wkdij7D0ypAAAAJXRFWHRkYXRlOmNyZWF0ZQAyMDE2LTA1LTI3VDE5OjM3OjMzKzAyOjAwaw2jVAAAACV0RVh0ZGF0ZTptb2RpZnkAMjAxNi0wNS0yN1QxOTozNzozMyswMjowMBpQG+gAAAAZdEVYdFNvZnR3YXJlAHd3dy5pbmtzY2FwZS5vcmeb7jwaAAAAAElFTkSuQmCC' alt=''> powered by <img src='http://10.10.6.125:8090/praizer/static/img/logo-twhp.png' width='60'></div></body></html>";
		    int width = 1000, height = 500;

		    BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
		        .getDefaultScreenDevice().getDefaultConfiguration()
		        .createCompatibleImage(width, height);

		    Graphics graphics = image.createGraphics();

		    JEditorPane jep = new JEditorPane("text/html", html);
		    //JEditorPane jep = new JEditorPane();
//		    Kit kit = new Kit();
//		    jep.setEditorKit(kit);
		    //jep.setPage("http://10.10.6.125:8090/praizer/");
		    
		    jep.setSize(width, height);
		    jep.print(graphics);
		    

		    ImageIO.write(image, "png", new File("/Users/georgeg/Desktop/praizer/hello-world2.png"));
	}

}
