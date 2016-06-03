package com.seismaismais.praiser.test;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class NavegateDOMElementsIntegrationTest {

	@Test
	public void test() throws IOException {
				
		Document doc = Jsoup.parse("<div name='slide' ng-repeat='phase in ctrl.phases' class='ng-scope'><div style='font-family:arial;margin:0.2em;border:1px solid #000000;text-align:center;width:300px;height:200px;float:left' class='ng-binding'>Nosso Deus<div style='clear:both'></div></div></div><div name='slide' ng-repeat='phase in ctrl.phases' class='ng-scope'><div style='font-family:arial;margin:0.2em;border:1px solid #000000;text-align:center;width:300px;height:200px;float:left' class='ng-binding'>Nosso Deus<div style='clear:both'></div></div></div>");
		
		Elements divs = doc.getElementsByAttributeValue("name", "slide");
		
		for (Element div : divs) {
		  System.out.println(div.html());
		}
	}

}
