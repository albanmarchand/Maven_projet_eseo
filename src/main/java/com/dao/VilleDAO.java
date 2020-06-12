package com.dao;

import java.util.List;

import com.dto.Ville;

public interface VilleDAO {
	
	public List<Ville> findAllVilles(String codeCommune, String nomCommune, String codePostal,
			String libelleAcheminement, String ligne);

	public void createVille(Ville ville);

}
