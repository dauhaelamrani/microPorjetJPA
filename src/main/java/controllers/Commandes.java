package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.CommandeDaoImpl;
import dao.impl.LigneCommandeDaoImpl;
import models.Commande;
import models.LigneCommande;

public class Commandes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer codeClient = (Integer) session.getAttribute("client_id");
		
		List<LigneCommande> lignesCommande = null;
		Commande commande  = new CommandeDaoImpl().findByCodeClient(codeClient);
		
		if (commande != null) {
			lignesCommande = new LigneCommandeDaoImpl().findByNumCommande(commande.getNumCommande());
		}
		
		request.setAttribute("commande", commande);
		request.setAttribute("lignesCommande", lignesCommande);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/commandes.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer codeClient = (Integer) session.getAttribute("client_id");
		
		Commande commande = new CommandeDaoImpl().findByCodeClient(codeClient);
		if (commande != null)
			new CommandeDaoImpl().delete(commande.getNumCommande());
		
		response.sendRedirect(request.getContextPath() + "/");
	}
}
