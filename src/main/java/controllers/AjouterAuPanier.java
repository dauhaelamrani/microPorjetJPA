package controllers;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.ArticleDaoImpl;
import dao.impl.ClientDaoImpl;
import dao.impl.CommandeDaoImpl;
import dao.impl.LigneCommandeDaoImpl;
import models.Article;
import models.Client;
import models.Commande;
import models.LigneCommande;

public class AjouterAuPanier extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
	
	private ArticleDaoImpl articleDaoImpl = new ArticleDaoImpl();
	
	private CommandeDaoImpl commandeDaoImpl = new CommandeDaoImpl();
	
	private LigneCommandeDaoImpl ligneCommandeDaoImpl = new LigneCommandeDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codeArticle = request.getParameter("codeArticle");
		HttpSession session = request.getSession();
		
		// Get the client id using session
		Integer codeClient = (Integer) session.getAttribute("client_id");
		
		Client client = clientDaoImpl.findById(codeClient);
		
		// Check if the codeArticle exists
		Article article = articleDaoImpl.findByCodeArticle(codeArticle);
		if (article != null) {
			
			// Check if there is an existing command for the current user
			Commande commande = commandeDaoImpl.findByCodeClient(codeClient);
			if (commande == null) {
				commande = new Commande();
				commande.setDateCommande(new Date());
				commande.setClient(client);
				
				// If it doesn't exist create a new command for him
				commandeDaoImpl.create(commande);
			}
			
			// Check if he already added this article to his card
			// If it's true increment the quantity only
			LigneCommande ligneCommande = ligneCommandeDaoImpl.findByNumCommandeEtCodeArticle(commande.getNumCommande(), codeArticle); 
			if (ligneCommande == null) {
				ligneCommande = new LigneCommande();
				ligneCommande.setArticle(article);
				ligneCommande.setCommande(commande);
				ligneCommande.setQteCode(1);
				
				ligneCommandeDaoImpl.create(ligneCommande); 
			} else {
				ligneCommande.setQteCode(ligneCommande.getQteCode() + 1);
				ligneCommandeDaoImpl.update(ligneCommande); 
			}
			
			response.sendRedirect(request.getHeader("referer"));
			
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
