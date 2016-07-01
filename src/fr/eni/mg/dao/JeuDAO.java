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

import fr.eni.mg.bo.Jeu;
import fr.eni.mg.bo.Joueur;
import fr.eni.mg.util.AccesBase;

/**
 * @author Administrateur
 * @date 30 juin 2016
 * @version MultiGamesENI - V1.0
 *
 */
public class JeuDAO {

	/**
<<<<<<< HEAD
	 * Retourne la liste des jeux présent dans la BD.
=======
	 * Retourne la liste des jeux présente dans la BD.
>>>>>>> branch 'master' of https://github.com/YannisPV/MultiGamesENI
	 * @return La liste peut être vide mais jamais <code>null</code>
	 * @throws SQLException Exception de type SQL.
	 */
	public static List<Jeu> ListeJeux()throws SQLException {
		Connection cnx=null;
		Statement rqt=null;
		ResultSet rs=null;
		List<Jeu> ListeJeux = new ArrayList<Jeu>();
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.createStatement();			
			rs=rqt.executeQuery("select * from jeux");
			Jeu jeu;
			while (rs.next()){
				jeu = new Jeu(
						);
				ListeJeux.add(jeu);				
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return ListeJeux;
	}	
	/**
	 * Méthode qui permet d'ajouter un jeu dans la BD.
	 * @param jeu Bean jeu à ajouter.
	 * @throws SQLException Exception de type SQL.
	 */
	public static void ajouter(Jeu jeu) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("insert into jeux(nom) values (?)");
			rqt.setString(1, jeu.getNom());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * Méthode qui permet de supprimer un jeu dans la BD.
	 * @param jeu Bean jeu à supprimer.
	 * @throws SQLException Exception de type SQL.
	 */
	public static void supprimer(Jeu jeu) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("delete from jeux where id = ?");
			rqt.setInt(1, jeu.getId());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * Méthode qui permet de modifier un jeu dans la BD.
	 * @param jeu Bean jeu à modifer.
	 * @throws SQLException Exception de type SQL.
	 */
	public static void modifier(Jeu jeu) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("update jeux set nom = ? where id = ?");
			rqt.setString(1, jeu.getNom());
			rqt.setInt(2, jeu.getId());

			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	/**
	 * Méthode qui permet de rechercher un jeu dans la BD.
	 * @param jeu Bean jeu à rechercher.
	 * @throws SQLException Exception de type SQL.
	 */
	public static Jeu rechercherById(Jeu jeu) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("select * from jeux where id = ?");
			rqt.setInt(1, jeu.getId());
			rs=rqt.executeQuery();
			while (rs.next()){
				jeu.setNom(rs.getString("nom"));
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return jeu;
	}
	
	/**
	 * Méthode qui permet de rechercher un jeu dans la BD.
	 * @param jeu Bean jeu à rechercher.
	 * @throws SQLException Exception de type SQL.
	 */
	public static Jeu rechercheId(Jeu jeu) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		Jeu jeuResult = null;
		try{
			
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("select * from jeux where nom = ?");
			rqt.setString(1, jeu.getNom());
			rs=rqt.executeQuery();
			while (rs.next()){
				jeuResult = new Jeu(rs.getInt("id"), rs.getString("nom"));
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return jeuResult;
	}
}
