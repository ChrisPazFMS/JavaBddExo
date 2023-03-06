package fr.fms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.entities.User;

public class UserDao implements Dao<User>{

	@Override
	public void creat(User obj) {

		String insert = "INSERT INTO T_Users (Login, Password) VALUES ('" + obj.getLogin() + "'" + ",'"
				+ obj.getPasseword() + "')";
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
		String showArticle = "SELECT * FROM T_Users where IdUser=" + id;
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultUser = statement.executeQuery(showArticle);
			if (resultUser.next()) {
				int rsIdUser = resultUser.getInt(1);
				String rsLogin = resultUser.getString(2);
				String rsPassword = resultUser.getString(3);

				System.out.println("\u001B[33m" + rsIdUser + " " + rsLogin + " " + rsPassword + " " + "\u001B[39m");
			}
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public boolean update(User obj) {
		String upDate = "UPDATE T_Users SET Login='" + obj.getLogin() + "', Password='" + obj.getPasseword()
				+ "' where IdUser=7";

		Statement statement = null;

		try {
			statement = BddConnection.getConnection().createStatement();
			statement.executeUpdate(upDate);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("UPDATE User ID : " + obj.getIdUsers() + " " + false);
			return false;
		}
		System.out.println("UPDATE User ID : " + obj.getIdUsers() + " " + true);
		return true;
	}

	@Override
	public boolean delete(User obj) {
		String delete = "DELETE FROM T_Users WHERE IdUser=" + obj.getIdUsers();
		Statement statement = null;

		try {
			statement = BddConnection.getConnection().createStatement();
			statement.execute(delete);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete Article ID : " + obj.getIdUsers() + " " + false);
			return false;
		}
		System.out.println("Delete Article ID : " + obj.getIdUsers() + " " + true);
		return true;
	}

	@Override
	public ArrayList<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
