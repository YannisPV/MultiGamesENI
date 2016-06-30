/**
 *  Classe en charge de.
 */
package fr.eni.mg.bo;

/**
 * @author Administrateur
 * @date 30 juin 2016
 * @version MultiGamesENI - V1.0
 *
 */
public class Partie {
	private int id;
	private Jeu jeu;
	private Joueur joueur;
	private boolean resultat;
	/**
	 * Constructeur .
	 */
	public Partie() {
		super();
	}
	/**
	 * Constructeur .
	 * @param id
	 * @param jeu
	 * @param joueur
	 * @param resultat
	 */
	public Partie(int id, Jeu jeu, Joueur joueur, boolean resultat) {
		super();
		this.id = id;
		this.jeu = jeu;
		this.joueur = joueur;
		this.resultat = resultat;
	}
	/**
	 * Getter pour id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter pour id.
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter pour jeu.
	 * @return the jeu
	 */
	public Jeu getJeu() {
		return jeu;
	}
	/**
	 * Setter pour jeu.
	 * @param jeu the jeu to set
	 */
	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}
	/**
	 * Getter pour joueur.
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}
	/**
	 * Setter pour joueur.
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	/**
	 * Getter pour resultat.
	 * @return the resultat
	 */
	public boolean isResultat() {
		return resultat;
	}
	/**
	 * Setter pour resultat.
	 * @param resultat the resultat to set
	 */
	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}
	
	
}
