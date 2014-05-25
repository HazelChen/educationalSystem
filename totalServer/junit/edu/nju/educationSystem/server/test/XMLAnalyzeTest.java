package edu.nju.educationSystem.server.test;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.educationSystem.server.xmlHandler.XMLAnalyzer;

public class XMLAnalyzeTest {
	
	@Test
	public void test() {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<courses>\n<course>\n<id>0000000</id>\n<name>广告学</name>\n<time>37</time>\n<score>3</score>\n<teacher>刘峰</teacher>\n<location>仙一</location>" + 
				"\n</course>\n<course>\n<id>0000001</id>\n<name>心理学</name>\n<time>40</time>\n<score>5</score>\n<teacher>赵志宏</teacher>\n<location>仙二</location>\n</course>\n</courses>";
		
		XMLAnalyzer xmlAnalyzer = new XMLAnalyzer(xml);
		while (xmlAnalyzer.hasNext()) {
			ArrayList<String> arrayList = xmlAnalyzer.next();
			
			for (int i = 0; i < arrayList.size(); i++) {
				System.out.print(arrayList.get(i));
			}
			System.out.println();
		}
	}
}
