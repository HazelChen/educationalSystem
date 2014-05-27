package edu.nju.educationSystem.server.xmlHandler;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.DocumentSource;

public class XMLTransform {

	public String transform(String input, String model) {
		System.out.println("=============from============");
		System.out.println(input);
		String re = null;
		try {
			Document document = DocumentHelper.parseText(input);
			TransformerFactory factory = TransformerFactory.newInstance();
			StreamSource xsl = new StreamSource(new File("xsl/" + model + ".xsl"));

			Transformer transform = factory.newTransformer(xsl);
			DocumentSource source = new DocumentSource(document);
			DocumentResult result = new DocumentResult();
			transform.transform(source, result);
			Document transformDoc = result.getDocument();
			re = transformDoc.asXML();
			System.out.println("=============to===========");
			System.out.println(re);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
}
