package emsystem.xml;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import emsystem.model.ModelSpecification;

public class XMLGenerater {
	private Class<?> objectClass;
	private String rootString;
	private String elementString;
	
	private Map<String, String> attributeAndColumns;

	private Document document;
	private Element rootElement;

	public XMLGenerater(String root, String element) {
		this.rootString = root;
		this.elementString = element;
		this.document = DocumentHelper.createDocument();
		this.rootElement = document.addElement(rootString);
	}
	
	public XMLGenerater(String root, String element, Class<?> objectClass, ModelSpecification modelSpecification) {
		this(root, element);
		this.objectClass = objectClass;
		this.attributeAndColumns = modelSpecification.getFieldCorrespondence();
	}

	public void generateDocument(ResultSet resultSet) {
		try {
			ResultSetMetaData rsmd = resultSet.getMetaData();

			int count = rsmd.getColumnCount();

			String[] columnNames = new String[count];
			for (int i = 0; i < count; i++) {
				columnNames[i] = rsmd.getColumnName(i + 1);
			}

			while (resultSet.next()) {
				Element emp = rootElement.addElement(elementString);
				for (int i = 0; i < count; i++) {
					Element column = emp.addElement(columnNames[i]);
					if (resultSet.getObject(i + 1) != null) {
						column.setText(resultSet.getObject(i + 1) + "");
					} else {
						column.setText("");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addElement(Object object) {
		object = objectClass.cast(object);
		Element singleObject = rootElement.addElement(elementString);
		
		Iterator<Entry<String, String>> iterator = attributeAndColumns.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			String columnString = entry.getValue();
			Element column = singleObject.addElement(columnString);
			String methodName = "";
			if (methodName.length() == 1) {
				methodName = "get" + Character.toUpperCase(entry.getKey().charAt(0));
			} else {
				methodName = "get" + Character.toUpperCase(entry.getKey().charAt(0)) + entry.getKey().substring(1);
			}
			String value = "";
			try {
				Method method = objectClass.getDeclaredMethod(methodName);
				value = (String)(method.invoke(object) + "");
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			column.setText(value);
		}
		for (int i = 0; i < attributeAndColumns.size(); i++) {
		}
	}

	public String getXmlString() {
		StringWriter writer = new StringWriter();
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("utf-8");
		XMLWriter xmlWriter = new XMLWriter(writer, outputFormat);
		try {
			xmlWriter.write(document);
			xmlWriter.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

}
