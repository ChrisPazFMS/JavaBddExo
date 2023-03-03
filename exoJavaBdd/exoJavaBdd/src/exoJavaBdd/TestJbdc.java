package exoJavaBdd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class TestJbdc {

	// https://www.laulem.com/dev/java/properties.html

	public static void main(String[] args) throws IOException {

		ArrayList<Article> articles = new ArrayList<Article>();

		/**
		 * €xo 4
		 */
		Properties prop = readPropertiesFile("src/credentials.properties");
		try {

			Class.forName(prop.getProperty("db.driver.class"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = prop.getProperty("db.url");
		String login = prop.getProperty("db.login");
		String password = prop.getProperty("db.password");

		/**
		 * Exo 3
		 */
		try (Connection connection = DriverManager.getConnection(url, login, password)) {

			String showTableShop = "SELECT * FROM T_Articles";
			// String insert = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice,
			// IdCategory) VALUES ('Telephone portable', 'Samsung galaxy s23 ultra', 450,
			// 2)";
			// String upDate = "UPDATE T_Articles SET Description='Telephone portable',
			// Brand='Nokia 8210', UnitaryPrice=156, IdCategory=2 WHERE IdArticle = 2";
			// String delete = "DELETE FROM T_Articles WHERE IdArticle=22";

			try (Statement statement = connection.createStatement()) {
				// statement.execute(insert);
				// statement.executeUpdate(upDate);
				// statement.executeUpdate(delete);
				showArticle(5);

				try (ResultSet resultSet = statement.executeQuery(showTableShop)) {

					while (resultSet.next()) {

						int rsIdUser = resultSet.getInt(1);
						String rsDescription = resultSet.getString(2);
						String rsBrand = resultSet.getString(3);
						double rsPrice = resultSet.getDouble(4);
						int rsCategory = resultSet.getInt(5);
						articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice, rsCategory)));

					}

					connection.close();
				}

			}

			for (Article article : articles) {
				System.out.println(article.getId() + " - " + article.getDescription() + " - " + article.getBrand()
						+ " - " + article.getPrice() + " - " + article.getCategory());
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	private static void showArticle(int id) throws SQLException {

		String url = "jdbc:mariadb://localhost:3306/Shop";
		String login = "root";
		String password = "fms2023";
		Connection connection = DriverManager.getConnection(url, login, password);
		String showArticle = "SELECT * FROM T_Articles where IdArticle=" + id;

		Statement statement = connection.createStatement();
		ResultSet resultShowArticle = statement.executeQuery(showArticle);

		if (resultShowArticle.next()) {
			int rsIdUser = resultShowArticle.getInt(1);
			String rsDescription = resultShowArticle.getString(2);
			String rsBrand = resultShowArticle.getString(3);
			double rsPrice = resultShowArticle.getDouble(4);
			int rsCategory = resultShowArticle.getInt(5);
			System.out.println("\u001B[33m" + rsIdUser + " " + rsDescription + " " + rsBrand + " " + rsPrice + " "
					+ rsCategory + "\u001B[39m");

		}
		connection.close();
	}

	public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}

}
