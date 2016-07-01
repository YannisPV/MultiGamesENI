package fr.eni.mg.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.mg.bo.Joueur;
import fr.eni.mg.dao.JoueurDAO;

/**
 * Servlet implementation class DoDisplayJeux
 */
public class DoDisplayJeux extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoDisplayJeux() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Méthode en charge d'afficher la page des jeux
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
		RequestDispatcher dispatcher;
		Joueur joueurConnecte = null;


		// Si le joueur est déjà connecté, on redirige vers le menu jeux
		joueurConnecte = (Joueur)request.getSession().getAttribute("joueurConnecte");
		if (joueurConnecte!=null) {
			redirectionMenuJeux(request, response);
			return;
		}		
		try {
			String pseudo =  request.getParameter("pseudo");
			if (   (pseudo == null) || (pseudo.length() == 0)) {
				String message = "Les champs pseudo sont obligatoires";
				request.setAttribute("messageErreur", message);
				this.getServletContext().getRequestDispatcher("/index").forward(request, response);
				return;
			}
			else{
				try {
					// Valider l'identification par rapport aux informations de la base
					joueurConnecte = JoueurDAO.rechercheId(new Joueur(0,pseudo));
					if (joueurConnecte == null){
						JoueurDAO.ajouter(new Joueur(0,pseudo));
						joueurConnecte = JoueurDAO.rechercheId(new Joueur(0,pseudo));
					}
				} catch (SQLException sqle) {
					// Placer l'objet représentant l'exception dans le contexte de requete
					request.setAttribute("erreur", sqle);
					// Passer la main à la page de présentation des erreurs
					dispatcher = getServletContext().getRequestDispatcher("/afficherErreur");
					dispatcher.forward(request, response);
					return;
				}		
				request.getSession().setAttribute("joueurConnecte", joueurConnecte);
				// Présenter la réponse
				redirectionMenuJeux(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methode en charge de .
	 * @param request
	 * @param response
	 */
	private void redirectionMenuJeux(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jeux.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
