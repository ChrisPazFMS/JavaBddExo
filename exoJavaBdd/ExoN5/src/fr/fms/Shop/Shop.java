package fr.fms.Shop;
import fr.fms.dao.ArticleDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;

public class Shop {

	public static void main(String[] args) {

		ArticleDao shop = new ArticleDao();
		UserDao user = new UserDao();
		
		//user.creat(new User("toto","T123"));
		//user.update(new User(7,"tata","T123"));
		//user.delete(new User(7));
		user.read(7);

		// shop.creat(new Article("voiture", "ford", 45000, 2));
		// shop.delete(new Article(58));
		//shop.update(new Article(20, "Telephone", "Samsung", 451, 2));
		//shop.read(40);

		shop.readAll();
	}

}