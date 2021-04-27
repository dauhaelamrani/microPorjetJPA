package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.ArticleDaoImpl;
import dao.impl.ClientDaoImpl;
import models.Client;

public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String viewFile = "WEB-INF/views/accueil1.jsp";
		if (session.getAttribute("isAuthenticated") != null && (Boolean) session.getAttribute("isAuthenticated") == true) {
			
			Client client = clientDaoImpl.findById((Integer) session.getAttribute("client_id"));
			
			request.setAttribute("client", client);
			viewFile = "WEB-INF/views/accueil2.jsp";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(viewFile);
		view.forward(request, response);
	}

}
