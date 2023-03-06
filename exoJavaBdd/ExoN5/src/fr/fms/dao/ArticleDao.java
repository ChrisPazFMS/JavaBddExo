package fr.fms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class ArticleDao implements Dao<Article> {

	private ArrayList<Article> articles;

	public ArticleDao() {
		articles = new ArrayList<Article>();

	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	@Override
	public void creat(Article obj) {

		String insert = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice, IdCategory) VALUES ('"
				+ obj.getDescription() + "'," + "'" + obj.getBrand() + "'" + "," + obj.getPrice() + ","
				+ obj.getCategory() + ")";
		Statement statement;
		try {
			statement = BddConnection.getConnection().createStatement();
			statement.execute(insert);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void read(int id) {
		String showArticle = "SELECT * FROM T_Articles where IdArticle=" + id;
		Statement statement;
		try {
			statement = connection.createStatement();
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
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public boolean update(Article obj) {
		String upDate = "UPDATE T_Articles SET Description='" + obj.getDescription() + "', Brand='" + obj.getBrand()
				+ "', UnitaryPrice=" + obj.getPrice() + ", IdCategory=" + obj.getCategory() + " WHERE IdArticle ="
				+ obj.getId();

		Statement statement = null;

		try {
			statement = BddConnection.getConnection().createStatement();
			statement.executeUpdate(upDate);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("UPDATE Article ID : " + obj.getId() + " " + false);
			return false;
		}
		System.out.println("UPDATE Article ID : " + obj.getId() + " " + true);
		return true;

	}

	@Override
	public boolean delete(Article obj) {
		String delete = "DELETE FROM T_Articles WHERE IdArticle=" + obj.getId();
		Statement statement = null;

		try {
			statement = BddConnection.getConnection().createStatement();
			statement.execute(delete);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete Article ID : " + obj.getId() + " " + false);
			return false;
		}
		System.out.println("Delete Article ID : " + obj.getId() + " " + true);
		return true;
	}

	@Override
	public ArrayList<Article> readAll() {

		String showTableShop = "SELECT * FROM T_Articles";
		Statement statement;
		try {
			statement = BddConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(showTableShop);
			while (resultSet.next()) {
				int rsIdUser = resultSet.getInt(1);
				String rsDescription = resultSet.getString(2);
				String rsBrand = resultSet.getString(3);
				double rsPrice = resultSet.getDouble(4);
				int rsCategory = resultSet.getInt(5);
				articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice, rsCategory)));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		for (Article string : articles) {

			System.out.println("\u001B[31mID : \u001B[39m" + string.getId() + " \u001B[33mDescription : \u001B[39m"
					+ string.getDescription() + " \u001B[33mBrand : \u001B[39m" + string.getBrand()
					+ " \u001B[33mCategory : \u001B[39m" + string.getCategory());
		}
		return articles;
	}

}
