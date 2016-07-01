/**
 *  Classe en charge de.
 */
package fr.eni.mg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.mg.bo.Joueur;
import fr.eni.mg.util.AccesBase;

/**
 * @author Administrateur
 * @date 30 juin 2016
 * @version MultiGamesENI - V1.0
 *
 */
public class JoueurDAO {

	/**
<<<<<<< HEAD
	 * Retourne la liste des joueurs présent dans la BD.
=======
	 * Retourne la liste des joueurs présente dans la BD.
>>>>>>> branch 'master' of https://github.com/YannisPV/MultiGamesENI
	 * @return La liste peut être vide mais jamais <code>null</code>
	 * @throws SQLException Exception de type SQL.
	 */
	public static List<Joueur> ListeJoueurs()throws SQLException {
		Connection cnx=null;
		Statement rqt=null;
		ResultSet rs=null;
		List<Joueur> listeJoueurs = new ArrayList<Joueur>();
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.createStatement();			
			rs=rqt.executeQuery("select * from joueurs");
			Joueur joueur;
			while (rs.next()){
				joueur = new Joueur(
						);
				listeJoueurs.add(joueur);				
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return listeJoueurs;
	}	
	/**
	 * Méthode qui permet d'ajouter un joueur dans la BD.
	 * @param joueur Bean joueur à ajouter.
	 * @throws SQLException Exception de type SQL.
	 */
	public static void ajouter(Joueur joueur) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("insert into joueurs(nom) values (?)");
			rqt.setString(1, joueur.getNom());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * Méthode qui permet de supprimer un joueur dans la BD.
	 * @param joueur Bean joueur à supprimer.
	 * @throws SQLException Exception de type SQL.
	 */
	public static void supprimer(Joueur joueur) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("delete from joueurs where id = ?");
			rqt.setInt(1, joueur.getId());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * Méthode qui permet de modifier un joueur dans la BD.
	 * @param joueur Bean joueur à modifer.
	 * @throws SQLException Exception de type SQL.
	 */
	public static void modifier(Joueur joueur) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("update joueurs set nom = ? where id = ?");
			rqt.setString(1, joueur.getNom());
			rqt.setInt(2, joueur.getId());

			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	/**
	 * Méthode qui permet de rechercher un joueur dans la BD.
	 * @param joueur Bean joueur à rechercher.
	 * @throws SQLException Exception de type SQL.
	 */
	public static Joueur rechercherById(Joueur joueur) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("select * from joueurs where id = ?");
			rqt.setInt(1, joueur.getId());
			rs=rqt.executeQuery();
			while (rs.next()){
				joueur.setNom(rs.getString("nom"));
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return joueur;
	}
}
