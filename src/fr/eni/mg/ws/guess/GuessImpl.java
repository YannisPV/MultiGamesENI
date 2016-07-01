/**
 * Classe en charge de .
 */
package fr.eni.mg.ws.guess;

import java.util.Hashtable;
import java.util.Random;

import javax.jws.WebService;

/**
 * @author Administrateur
 * @date 30 juin 2016
 * @version MultiGamesENI - V1.0
 */
@WebService(endpointInterface = "fr.eni.mg.ws.guess.Guess")
public class GuessImpl implements Guess {

	private Hashtable tabGame = new Hashtable();
	/** 
	 * {@inheritDoc}
	 * @see fr.eni.mg.ws.guess.Guess#guess(int)
	 */
	@Override
	public String guess(int number, String nom) {
		int numberToFind = GetNumber(nom);
		if(number > numberToFind){
			return "moins";
		}else if(number < numberToFind){
			return "plus";
		}
		tabGame.remove(nom);
		return "gagner";
	}

	/** 
	 * {@inheritDoc}
	 * @see fr.eni.mg.ws.guess.Guess#newGame()
	 */
	@Override
	public int GetNumber(String nom) {
		if(!tabGame.containsKey(nom)){
			Random rand = new Random();
			tabGame.put(nom, rand.nextInt(100));
		}else if((Integer)tabGame.get(nom) == 0){
			tabGame.remove(nom);
			return GetNumber(nom);
		}
		return (Integer)tabGame.get(nom);
	}

}
