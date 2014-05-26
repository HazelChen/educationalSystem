package edu.nju.educationSystem.server.xmlHandler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidate {

	public void validateXml(String xsdPath, String input) {
		try {
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");
			File schemaFile = new File(xsdPath);

			InputStream in_withcode = new ByteArrayInputStream(
					input.getBytes("UTF-8"));
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			Source source = new StreamSource(in_withcode);
			validator.validate(source);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
