package com.bonsaiui.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class BonsaiConfigurationReader {
	
	private static Properties pro;
    static{
        String path = "src\\test\\resources\\Properties\\bonsai.properties";
        
        //Any class with input and output, will throw exception and will need to be handle by Try and cath 
        try {
            FileInputStream file = new FileInputStream(path);
            pro = new Properties();
            pro.load(file);
            file.close();
        } catch (Exception e) {
            System.out.println("Path: " + path + " - not found.");
        }
    }
    
    //Properties is a subclass of hashtable  
    //This method will work with Key & Value pair. 
    //We use Key & Value pair in maps and patameters inside TestNG 
    public static String getProperty(String key){
        return pro.getProperty(key);
    }
}
