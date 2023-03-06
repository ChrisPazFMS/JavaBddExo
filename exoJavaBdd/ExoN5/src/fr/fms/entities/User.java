package fr.fms.entities;

public class User {
	int idUsers;
	String login;
	String passeword;
	
	public User(int idUsers, String login, String passeword) {
		this.idUsers = idUsers;
		this.login = login;
		this.passeword = passeword;
	}
	
	public User(String login, String passeword) {
		this.login = login;
		this.passeword = passeword;
	}
	
	public User(int idUsers) {
		this.idUsers = idUsers;
	}

	public int getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasseword() {
		return passeword;
	}

	public void setPasseword(String passewor) {
		this.passeword = passewor;
	}
	
	

}
