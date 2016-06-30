/**
 *  Classe en charge de.
 */
package fr.eni.mg.dao;

import java.sql.Connection;
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

	public static List<Joueur> ListeJoueur()throws SQLException {
		Connection cnx=null;
		Statement rqt=null;
		ResultSet rs=null;
		List<Joueur> listeJoueurs = new ArrayList<Joueur>();
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.createStatement();			
			rs=rqt.executeQuery("select * from formations");
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
}
