package fr.fms.Shop;

import fr.fms.dao.ArticleDao;
import fr.fms.entities.Article;

public class Shop {

	public static void main(String[] args) {

		ArticleDao shop = new ArticleDao();

		// shop.creat(new Article("voiture", "ford", 45000, 2));
		// shop.delete(new Article(58));
		shop.update(new Article(20, "Telephone", "Samsung", 451, 2));
		shop.read(40);

		shop.readAll();
	}

}
