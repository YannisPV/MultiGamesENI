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
public class Joueur {
	private int id;
	private String nom;
	/**
	 * Constructeur .
	 */
	public Joueur() {
		super();
	}
	/**
	 * Constructeur .
	 * @param id
	 * @param nom
	 */
	public Joueur(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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
	 * Getter pour nom.
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Setter pour nom.
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
