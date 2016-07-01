package fr.eni.mg.servlets;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

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
			url = new URL(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
					request.getContextPath() + "/Guess?wsdl");
			
			QName qname = new QName("http://guess.ws.mg.eni.fr/", "GuessImplService");
			
			Service service = Service.create(url, qname);
			
			Guess guess = service.getPort(Guess.class);
			resultat = guess.guess(Integer.parseInt(request.getParameter("inputNumber")));
			request.setAttribute("resultat", resultat);
			
			// Condition en fonction d'une bonne ou d'une mauvaise réponse
			// Redirige sur la page du formulaire ou sur la page de victoire
			 this.getServletContext().getRequestDispatcher("/guess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
