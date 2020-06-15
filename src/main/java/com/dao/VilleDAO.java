package com.dao;

import java.util.List;

import com.dto.Ville;

public interface VilleDAO {
	
	public List<Ville> findAllVilles(String codeCommune, String nomCommune, String codePostal,
			String libelleAcheminement, String ligne);

	public void ajoutVille(Ville ville);

	public void majVille(Ville ville);

	public void delVille(Ville ville);

}
