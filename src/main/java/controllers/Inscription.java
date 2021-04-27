package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ClientDaoImpl;
import models.Client;

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/inscrire.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom").trim();
		String prenom = request.getParameter("prenom").trim();
		String adresse = request.getParameter("adresse").trim();
		String email = request.getParameter("email").trim();
		String motPasse = request.getParameter("motPasse").trim();
		
		List<String> errors = new ArrayList<String>();
		
		if (nom == null || nom.isBlank()) {
			errors.add("last_name_required");
		}
		
		if (prenom == null || prenom.isBlank()) {
			errors.add("first_name_required");
		}
		
		if (adresse == null || adresse.isBlank()) {
			errors.add("address_required");
		}
		
		if (email == null || email.isBlank()) {
			errors.add("email_required");
		} else {
			Client client = new ClientDaoImpl().findByEmail(email);
			if (client != null) {
				errors.add("email_not_unique");
			}
		}
		
		if (motPasse == null || motPasse.isBlank()) {
			errors.add("password_required");
		}
		
		
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			doGet(request, response);
		} else {
			Client client = new Client();
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setAdresse(adresse);
			client.setEmail(email);
			client.setMotPasse(motPasse);
			
			new ClientDaoImpl().create(client);
			
			response.sendRedirect(request.getContextPath() + "/identifier");
		}
	}

}
