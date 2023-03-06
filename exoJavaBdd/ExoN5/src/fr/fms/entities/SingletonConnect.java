package fr.fms.entities;

import java.util.ArrayList;
import fr.fms.dao.Dao;

public class SingletonConnect implements Dao<Article> {

	// Static variable reference of single_instance
	// of type Singleton
	private static SingletonConnect single_instance = null;

	// Declaring a variable of type String

	// Constructor
	// Here we will be creating private constructor
	// restricted to this class itself
	private SingletonConnect() {

	}

	// Static method
	// Static method to create instance of Singleton class
	public static SingletonConnect getInstance() {
		if (single_instance == null)
			single_instance = new SingletonConnect();

		return single_instance;
	}

	@Override
	public void creat(Article obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void read(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Article> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void creat(User obj) {
		// TODO Auto-generated method stub
		
	}
}