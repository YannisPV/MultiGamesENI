/**
 *  Classe en charge de.
 */
package fr.eni.mg.ws.classement;

import java.util.List;

import fr.eni.mg.bo.Jeu;
import fr.eni.mg.bo.Partie;

/**
 * @author Administrateur
 * @date 1 juil. 2016
 * @version MultiGamesENI - V1.0
 *
 */
public interface Classement {
	
	public List<Object> classementParJeu(Jeu jeu, List<Partie> listeParties);
}
