package emsystem.xml;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLAnalyzer {
	private Iterator<?> iterator;

	public XMLAnalyzer(String xmlString) {
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(new StringReader(xmlString));
			Element root = document.getRootElement();
			iterator = root.elementIterator();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasNext() {
		return iterator.hasNext();
	}
	
	public ArrayList<String> next() {
		Element element = (Element)iterator.next();
		ArrayList<String> elementArrayList = new ArrayList<>();
		Iterator<?> attributeIterator = element.elementIterator();
		while (attributeIterator.hasNext()) {
			Element attribute = (Element) attributeIterator.next();
			elementArrayList.add(attribute.getStringValue());
		}
		return elementArrayList;
	}
}
