package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.ClientDaoImpl;
import models.Client;

public class Identification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/identifier.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").trim();
		String motPasse = request.getParameter("motPasse").trim();
		
		List<String> errors = new ArrayList<String>();
		
		if (email == null || email.isBlank()) {
			errors.add("email_required");
		}
		
		if (motPasse == null || motPasse.isBlank()) {
			errors.add("password_required");
		}
		
		
		if (errors.size() == 0) {
			Client client = new ClientDaoImpl().findByEmail(email);
			
			if (client == null  || !client.getMotPasse().equals(motPasse)) {
				errors.add("invalid_credentials");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("isAuthenticated", true);
				session.setAttribute("client_id", client.getId());
				
				response.sendRedirect(request.getContextPath());
				return;
			}
		}
		
		request.setAttribute("errors", errors);
		doGet(request, response);
	}

}
