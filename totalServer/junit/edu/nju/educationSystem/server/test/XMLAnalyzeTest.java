package edu.nju.educationSystem.server.test;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.educationSystem.server.xmlHandler.XMLAnalyzer;

public class XMLAnalyzeTest {
	
	@Test
	public void test() {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<courses>\n<course>\n<id>0000000</id>\n<name>���ѧ</name>\n<time>37</time>\n<score>3</score>\n<teacher>����</teacher>\n<location>��һ</location>" + 
				"\n</course>\n<course>\n<id>0000001</id>\n<name>����ѧ</name>\n<time>40</time>\n<score>5</score>\n<teacher>��־��</teacher>\n<location>�ɶ�</location>\n</course>\n</courses>";
		
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
