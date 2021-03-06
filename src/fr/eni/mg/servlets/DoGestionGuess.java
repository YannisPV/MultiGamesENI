package fr.eni.mg.servlets;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
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
import fr.eni.mg.dao.PartieDAO;
import fr.eni.mg.ws.guess.Guess;

/**
 * Servlet implementation class DoGestionGuess
 */
public class DoGestionGuess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoGestionGuess() {
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
		URL url = null;
		String resultat;
		try {
			
			Joueur joueurConnecte = (Joueur)request.getSession().getAttribute("joueurConnecte");
			url = new URL(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
					request.getContextPath() + "/Guess?wsdl");
			
			QName qname = new QName("http://guess.ws.mg.eni.fr/", "GuessImplService");
			
			Service service = Service.create(url, qname);
			
			Guess guess = service.getPort(Guess.class);
			if (request.getParameter("inputNumber")!=null){
				int inputnumber = Integer.parseInt(request.getParameter("inputNumber"));
				resultat = guess.guess(inputnumber, joueurConnecte.getNom());
				request.setAttribute("resultat", resultat);
				if ("gagner".equals(resultat)){
					Partie partie = (Partie) request.getSession().getAttribute("partie");
					partie.setResultat(true);
					PartieDAO.ModifPartie(partie);
					this.getServletContext().getRequestDispatcher("/jeux/jeux.jsp").forward(request, response);
					return;
				}
				
				// Condition en fonction d'une bonne ou d'une mauvaise réponse
				// Redirige sur la page du formulaire ou sur la page de victoire
				redirectionMenuJeux(request, response);
			}else{
				String message = "Le nombre ne peut être null";
				request.setAttribute("messageErreur", message);
				redirectionMenuJeux(request, response);
				return;
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jeux/guess.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
