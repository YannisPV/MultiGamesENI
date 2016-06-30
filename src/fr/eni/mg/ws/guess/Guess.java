/**
 * Classe en charge de .
 */
package fr.eni.mg.ws.guess;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * @author Administrateur
 * @date 30 juin 2016
 * @version MultiGamesENI - V1.0
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface Guess {
	
	@WebMethod
	public String guess(int number);
	
	@WebMethod
	public void newGame();
}
