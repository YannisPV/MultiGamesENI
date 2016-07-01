package fr.eni.mg.servlets;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.eni.mg.bo.Jeu;
import fr.eni.mg.bo.Joueur;
import fr.eni.mg.bo.Partie;
import fr.eni.mg.dao.JeuDAO;
import fr.eni.mg.dao.JoueurDAO;
import fr.eni.mg.dao.PartieDAO;
import fr.eni.mg.ws.guess.Guess;

/**
 * Servlet implementation class DoDisplayGuess
 */
public class DoDisplayGuess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoDisplayGuess() {
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
	 * Méthode en charge d'afficher la page d'accueil
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		Jeu jeu = new Jeu(0,"Guess");
		Joueur joueur =  (Joueur) request.getSession().getAttribute("joueurConnecte");
		try {
			jeu = JeuDAO.rechercheId(jeu);
			Partie partie = new Partie(0,jeu,joueur,false);
			partie = PartieDAO.addPartie(partie);
			request.getSession().setAttribute("partie", partie);
			this.getServletContext().getRequestDispatcher("/guess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
