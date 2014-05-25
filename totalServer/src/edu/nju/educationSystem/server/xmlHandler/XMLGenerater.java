package edu.nju.educationSystem.server.xmlHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XMLGenerater {
	private Class<?> objectClass;
	private String rootString;
	private String elementString;
	
	private String[] columnNames;

	private Document document;
	private Element rootElement;

	public XMLGenerater(String root, String element) {
		this.rootString = root;
		this.elementString = element;
		this.document = DocumentHelper.createDocument();
		this.rootElement = document.addElement(rootString);
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
	
	public void generateDocumentBaseInfo(Class<?> objectClass) {
		this.objectClass = objectClass;
		Field[] fields = objectClass.getDeclaredFields();
		columnNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			columnNames[i] = fields[i].getName();
		}
	}
	
	public void addElement(Object object) {
		object = objectClass.cast(object);
		Element singleObject = rootElement.addElement(elementString);
		
		for (int i = 0; i < columnNames.length; i++) {
			String columnString = columnNames[i];
			Element column = singleObject.addElement(columnString);
			String methodName = "";
			if (methodName.length() == 1) {
				methodName = "get" + Character.toUpperCase(columnNames[i].charAt(0));
			} else {
				methodName = "get" + Character.toUpperCase(columnNames[i].charAt(0)) + columnNames[i].substring(1);
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
