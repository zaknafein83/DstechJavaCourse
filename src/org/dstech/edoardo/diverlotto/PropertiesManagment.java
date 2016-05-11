/**
 * 
 */
package org.dstech.edoardo.diverlotto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author edoardo
 *
 */
public class PropertiesManagment {

	Properties prop;

	/**
	 * @throws IOException
	 * 
	 */
	public PropertiesManagment() {
		// TODO Auto-generated constructor stub
		try {
			prop = new Properties();
			//System.out.println("Load properties...");
			InputStream in = PropertiesManagment.class.getClassLoader().getResourceAsStream("resources/application.propertiesEdoardo");
			prop.load(in);
			in.close();
			//System.out.println("Properties has been loaded!");
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}


	public String getDBConnection() {
		//System.out.println("Trying to load " + Constants.DB_CONNECTION + "...");
		if (prop.containsKey(Constants.DB_CONNECTION)) {
			//System.out.println(Constants.DB_CONNECTION + " found!");
			return prop.getProperty(Constants.DB_CONNECTION);
		} else {
			System.out.println(Constants.DB_CONNECTION + " not found! Load DEFAULT_VALUE");
			return "NO_DB_CONNECTION";
		}
	}
	public String getDBUsername() {
		//System.out.println("Trying to load " + Constants.DB_USERNAME + "...");
		if (prop.containsKey(Constants.DB_USERNAME)) {
			//System.out.println(Constants.DB_USERNAME + " found!");
			return prop.getProperty(Constants.DB_USERNAME);
		} else {
			System.out.println(Constants.DB_USERNAME + " not found! Load DEFAULT_VALUE");
			return "root";
		}
	}
	public String getDBPassword() {
		//System.out.println("Trying to load " + Constants.DB_PASSWORD+ "...");
		if (prop.containsKey(Constants.DB_PASSWORD)) {
			//System.out.println(Constants.DB_PASSWORD + " found!");
			return prop.getProperty(Constants.DB_PASSWORD);
		} else {
			System.out.println(Constants.DB_PASSWORD + " not found! Load DEFAULT_VALUE");
			return "admin";
		}
	}
	public String getDBDriver() {
		//System.out.println("Trying to load " + Constants.DB_DRIVER + "...");
		if (prop.containsKey(Constants.DB_DRIVER)) {
			//System.out.println(Constants.DB_DRIVER + " found!");
			return prop.getProperty(Constants.DB_DRIVER);
		} else {
			System.out.println(Constants.DB_DRIVER + " not found! Load DEFAULT_VALUE");
			return "com.mysql.jdbc.Driver";
		}
	}

}
