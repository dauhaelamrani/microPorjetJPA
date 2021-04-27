package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ArticleDaoImpl;
import models.Article;

public class Catalogue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = new ArticleDaoImpl().findAll();
		
		request.setAttribute("articles", articles);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/catalogue.jsp");
		view.forward(request, response);
	}

}
