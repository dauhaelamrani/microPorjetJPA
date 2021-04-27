package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ArticleDaoImpl;
import models.Article;

public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Article article = new ArticleDaoImpl().findByCodeArticle(request.getParameter("codeArticle"));
		
		if (article == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		request.setAttribute("article", article);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/detail.jsp");
		view.forward(request, response);
	}

}
