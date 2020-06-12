package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;
	
	@Override
	public List<Ville> getInfoVille(String codeCommune, String nomCommune, String codePostal,
			String libelleAcheminement, String ligne) {
		List<Ville> ville;
		
		ville = villeDAO.findAllVilles(codeCommune, nomCommune, 
				codePostal, libelleAcheminement, ligne);
		return ville;
	}

	public void setInfoVille(Ville ville) {
		villeDAO.createVille(ville);
	}

}
