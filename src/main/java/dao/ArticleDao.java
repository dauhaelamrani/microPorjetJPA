package dao;

import java.util.List;

import models.Article;

public interface ArticleDao {
	List<Article> findAll();
	Article findByCodeArticle(String codeArticle);
}
