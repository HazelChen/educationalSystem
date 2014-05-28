package emsystem.rmi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	 private FileInputStream inputFile;
	 private static Properties properties;
	 public Config(){
		 properties= new Properties();   
	      try {   
	       inputFile=new FileInputStream("ipConfig.properties");
	       properties.load(inputFile);
	       inputFile.close();
	      } catch (IOException e1) {   
	       e1.printStackTrace();   
	      }   
	 }
	 
  public String getADataIP(){
   String s=properties.getProperty("AdatabaseIP");
   return s;
}

  public String getTotalIP(){
	  String s=properties.getProperty("totalIP");
	   return s;
  }

}
