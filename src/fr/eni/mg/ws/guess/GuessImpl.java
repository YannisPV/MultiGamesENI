/**
 * Classe en charge de .
 */
package fr.eni.mg.ws.guess;

import java.util.Random;

import javax.jws.WebService;

/**
 * @author Administrateur
 * @date 30 juin 2016
 * @version MultiGamesENI - V1.0
 */
@WebService(endpointInterface = "fr.eni.mg.ws.guess")
public class GuessImpl implements Guess {

	private int number;
	/** 
	 * {@inheritDoc}
	 * @see fr.eni.mg.ws.guess.Guess#guess(int)
	 */
	@Override
	public String guess(int number) {
		if(number > this.number){
			return "moins";
		}else if(number < this.number){
			return "plus";
		}
		return "gagner";
	}

	/** 
	 * {@inheritDoc}
	 * @see fr.eni.mg.ws.guess.Guess#newGame()
	 */
	@Override
	public void newGame() {
		Random rand = new Random();
		this.number = rand.nextInt(100);
	}

}
