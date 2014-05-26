package edu.nju.educationSystem.server.test;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.educationSystem.server.xmlHandler.XMLAnalyzer;
import edu.nju.educationSystem.server.xmlHandler.XMLTransform;

public class XMLAnalyzeTest {
	@Test
	public void test() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
				"<choices><choice><sid>0000000</sid><cid>广告学</cid><score>37</score></choice></choices>";
		
		XMLAnalyzer xmlAnalyzer = new XMLAnalyzer(xml);
		while (xmlAnalyzer.hasNext()) {
			ArrayList<String> arrayList = xmlAnalyzer.next();
			
			for (int i = 0; i < arrayList.size(); i++) {
				System.out.print(arrayList.get(i));
			}
			System.out.println();
		}
	}
	
	public void transform() {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<choices>\n<choice>\n<学生编号>0000000</学生编号>\n<课程编号>广告学</课程编号>\n<得分>37</得分></choice>\n</choices>";
		XMLTransform transform = new XMLTransform();
		String a = transform.transform(xml, "formatChoice.xsl");
		System.out.println(a);
	}
}
