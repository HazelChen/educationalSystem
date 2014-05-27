package edu.nju.educationSystem.server.test;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.educationSystem.server.xmlHandler.XMLAnalyzer;
import edu.nju.educationSystem.server.xmlHandler.XMLTransform;

public class XMLAnalyzeTest {
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
	
	@Test
	public void transform() {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<students>\n<student>\n<学号>0000000</学号>\n<名称>广告学</名称>\n<性别>男</性别><专业>男</专业></student>\n</students>";
		XMLTransform transform = new XMLTransform();
		String a = transform.transform(xml, "studentToT");
		System.out.println(a);
	}
}
