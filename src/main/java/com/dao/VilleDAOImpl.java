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
				Listeville.add(ville);
		   }

		} catch (SQLException e) {
		   //traitement de l'exception
		}
		return Listeville;
	}

	@Override
	public void createVille(Ville ville) {
Connection con = JDBCConfiguration.getConnection();
		
		ResultSet results = null;
		
		String requete = "INSERT INTO client (Code_commune_INSEE, Nom_commune, Code_postal,"
				+ " Libelle_acheminement, Ligne_5)" + 
				" VALUES" + 
				" ('Rébecca', 'Armand', 'Saint-Didier-des-Bois', 24)";
		try {
			   Statement stmt = con.createStatement();
			   results = stmt.executeQuery(requete);
		} catch (SQLException e) {
			  	//traitement de l'exception
		}
	}
}
