/**
 * Classe en charge de .
 */
package fr.eni.mg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.mg.bo.Jeu;
import fr.eni.mg.bo.Joueur;
import fr.eni.mg.bo.Partie;
import fr.eni.mg.util.AccesBase;

/**
 * @author Administrateur
 * @date 30 juin 2016
 * @version MultiGamesENI - V1.0
 */
public class PartieDAO {

	public static Partie getPartie(int id) throws Exception{
		Connection cnx = null;
		PreparedStatement cmd=null;
		try{
			cnx = AccesBase.getConnection();
			cmd = cnx.prepareStatement("SELECT Parties.id, JoueurId, JeuId, gagner, Jeux.id as JeuxId, Jeux.nom as JeuNom, Joueurs.id as JoueurId, Joueurs.nom as JoueurNom FROM Parties, Jeux, Joueurs WHERE Parties.JeuId = Jeux.id AND Parties.JoueurId = Joueurs.id AND JoueurId = ?");
			cmd.setInt(1, id);
			ResultSet rs = cmd.executeQuery();
			Partie partie;
	        while (rs.next()) {
	        	Jeu jeu = new Jeu(rs.getInt("JeuxId"), rs.getString("JeuNom"));
	        	Joueur joueur = new Joueur(rs.getInt("JoueurId"), rs.getString("JoueurNom"));
	        	return partie = new Partie(rs.getInt("id"), jeu, joueur, rs.getBoolean("gagner"));
	        }
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			throw new Exception("Problème de lecture Partie");
		}finally{
			if(cmd != null) cmd.close();
			if(cnx != null) cnx.close();
		}
		
		return null;
	}
	public static List<Partie> getParties() throws Exception{
		Connection cnx = null;
		PreparedStatement cmd=null;
		try{
			cnx = AccesBase.getConnection();
			cmd = cnx.prepareStatement("SELECT Parties.id, JoueurId, JeuId, gagner, Jeux.id as JeuxId, Jeux.nom as JeuNom, Joueurs.id as JoueurId, Joueurs.nom as JoueurNom FROM Parties, Jeux, Joueurs WHERE Parties.JeuId = Jeux.id AND Parties.JoueurId = Joueurs.id");
			ResultSet rs = cmd.executeQuery();
			List<Partie> listParties = new ArrayList<Partie>();
	        while (rs.next()) {
	        	Jeu jeu = new Jeu(rs.getInt("JeuxId"), rs.getString("JeuNom"));
	        	Joueur joueur = new Joueur(rs.getInt("JoueurId"), rs.getString("JoueurNom"));
	        	Partie partie = new Partie(rs.getInt("id"), jeu, joueur, rs.getBoolean("gagner"));
	        	listParties.add(partie);
	        }
	        
	        return listParties;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			throw new Exception("Problème de lecture Partie");
		}finally{
			if(cmd != null) cmd.close();
			if(cnx != null) cnx.close();
		}
	}
	
	public static void addPartie(Partie partie) throws Exception{
		Connection cnx = null;
		PreparedStatement cmd=null;
		try{
			cnx = AccesBase.getConnection();
			cmd = cnx.prepareStatement("INSERT INTO Partie (JoueurId, JeuId, gagner) VALUES(?, ?, ?)");
			cmd.setInt(1, partie.getJoueur().getId());
			cmd.setInt(2, partie.getJeu().getId());
			cmd.setBoolean(3, partie.getResultat());
			
			cmd.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			throw new Exception("Problème d'ajout Partie");
		}finally{
			if(cmd != null) cmd.close();
			if(cnx != null) cnx.close();
		}
	}
	
	public static void ModifPartie(Partie partie) throws Exception{
		Connection cnx = null;
		PreparedStatement cmd=null;
		try{
			cnx = AccesBase.getConnection();
			cmd = cnx.prepareStatement("UPDATE Partie SET JoueurId = ?, JeuId = ?, gagner = ?)");
			cmd.setInt(1, partie.getJoueur().getId());
			cmd.setInt(2, partie.getJeu().getId());
			cmd.setBoolean(3, partie.getResultat());
			cmd.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			throw new Exception("Problème de modification Partie");
		}finally{
			if(cmd != null) cmd.close();
			if(cnx != null) cnx.close();
		}
	}
	
	
}
