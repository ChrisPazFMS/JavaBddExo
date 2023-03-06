package fr.fms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import fr.fms.entities.Article;

public abstract class BddConnection extends CreatConfigFile implements Dao<Article> {
	String fileString;

	public static Connection getConnection() {

		Properties prop = null;
		try {
			prop = readPropertiesFile("src/credentials.properties");
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			Class.forName(prop.getProperty("db.driver.class"));
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		String url = prop.getProperty("db.url");
		String login = prop.getProperty("db.login");
		String password = prop.getProperty("db.password");

		try {
			return DriverManager.getConnection(url, login, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

}
