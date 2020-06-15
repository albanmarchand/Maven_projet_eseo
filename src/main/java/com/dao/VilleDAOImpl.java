package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	public List<Ville> findAllVilles(String codeCommune, String nomCommune, String codePostal,
			String libelleAcheminement, String ligne) {
		List<Ville> Listeville = new ArrayList<Ville>();
		Ville ville;
		
		Connection con = JDBCConfiguration.getConnection();
		
		ResultSet results = null;
		
		//String[] args = {codeCommune, nomCommune, codePostal, libelleAcheminement, ligne};
		String requete = "SELECT * FROM ville_france";
		if (codeCommune != null) {
			requete = requete + " WHERE Code_commune_INSEE = " + codeCommune;
		} else if (nomCommune != null) {
			requete = requete + " WHERE Nom_commune = '" + nomCommune + "'";
		} else if (codePostal != null) {
			requete = requete + " WHERE Code_postal = " + codePostal;
		} else if (libelleAcheminement != null) {
			requete = requete + " WHERE Libelle_acheminement = '" + libelleAcheminement + "'";
		} else if (ligne != null) {
			requete = requete + " WHERE Ligne_5 = '" + ligne + "'";
		}
		System.out.println(requete);

		try {
		   Statement stmt = con.createStatement();
		   results = stmt.executeQuery(requete);
		   
		   while (results.next()) {
				System.out.println("rep : " + results.getString("Nom_commune"));
				ville = new Ville();
				ville.setCodeCommune(results.getString("Code_commune_INSEE"));
				ville.setNomCommune(results.getString("Nom_commune"));
				ville.setCodePostal(results.getString("Code_postal"));
				ville.setLibelleAcheminement(results.getString("Libelle_acheminement"));
				ville.setLigne(results.getString("Ligne_5"));
				ville.setLatitude(results.getString("Latitude"));
				ville.setLongitude(results.getString("Longitude"));
				Listeville.add(ville);
		   }

		} catch (SQLException e) {
		   //traitement de l'exception
		}
		return Listeville;
	}

	public void ajoutVille(Ville ville) {
		Connection con = JDBCConfiguration.getConnection();
		
		int results;
		
		String requete = "INSERT INTO ville_France (Code_commune_INSEE, Nom_commune, Code_postal,"
				+ " Libelle_acheminement, Ligne_5, Latitude, Longitude) VALUES" + 
				" ('"+ ville.getCodeCommune() 
				+ "', '" + ville.getNomCommune() 
				+ "', '" + ville.getCodePostal() 
				+ "', '" + ville.getLibelleAcheminement() 
				+ "', '" + ville.getLigne() 
				+ "', '" + ville.getLatitude() 
				+ "', '" + ville.getLongitude()
				+ "')";
		try {
			System.out.println(requete);
			Statement stmt = con.createStatement();
			results = stmt.executeUpdate(requete);
			if(results == 1) {
				System.out.println("requete effectuée");
			} else {
				System.out.println("requete non effectuée");
			}
		} catch (SQLException e) {
			  	//traitement de l'exception
		}
	}

	public void majVille(Ville ville) {
		Connection con = JDBCConfiguration.getConnection();
		
		int results;
		
		String requete = "UPDATE ville_France SET "
				+ "Nom_commune = '" + ville.getNomCommune() 
				+ "', Code_postal = '" + ville.getCodePostal() 
				+ "', Libelle_acheminement = '" + ville.getLibelleAcheminement()
				+ "', Ligne_5 = '" + ville.getLigne()
				+ "', Latitude = '" + ville.getLatitude()
				+ "', Longitude = '" + ville.getLongitude() 
				+ "' WHERE Code_commune_INSEE = '" + ville.getCodeCommune() + "'";
			
		try {
			System.out.println(requete);
			Statement stmt = con.createStatement();
			results = stmt.executeUpdate(requete);
			if(results == 1) {
				System.out.println("requete effectuée");
			} else {
				System.out.println("requete non effectuée");
			}
		} catch (SQLException e) {
			  	//traitement de l'exception
		}
	}

	public void delVille(Ville ville) {
Connection con = JDBCConfiguration.getConnection();
		
		int results;
		
		String requete = "DELETE FROM ville_France WHERE "
				+ "Nom_commune = '" + ville.getNomCommune() 
				+ "' AND Code_postal = '" + ville.getCodePostal() 
				+ "' AND Libelle_acheminement = '" + ville.getLibelleAcheminement()
				+ "' AND Ligne_5 = '" + ville.getLigne()
				+ "' AND Latitude = '" + ville.getLatitude()
				+ "' AND Longitude = '" + ville.getLongitude() 
				+ "' AND Code_commune_INSEE = '" + ville.getCodeCommune() + "'";
			
		try {
			System.out.println(requete);
			Statement stmt = con.createStatement();
			results = stmt.executeUpdate(requete);
			if(results == 1) {
				System.out.println("requete effectuée");
			} else {
				System.out.println("requete non effectuée");
			}
		} catch (SQLException e) {
			  	//traitement de l'exception
		}
	}
}
