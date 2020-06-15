package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public List<Ville> appelGet(@RequestParam(value = "codeCommune", required = false) String codeCommune,
			@RequestParam(value = "nomCommune", required = false) String nomCommune, 
			@RequestParam(value = "codePostal", required = false) String codePostal,
			@RequestParam(value = "libelleAcheminement", required = false) String libelleAcheminement, 
			@RequestParam(value = "ligne", required = false) String ligne) {
		System.out.println("Appel GET");
		
		List<Ville> ville = villeBLOService.getInfoVille(codeCommune, nomCommune, 
				codePostal, libelleAcheminement, ligne);

		return ville;
	}
	
	// Methode POST
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestBody Ville ville) {
		System.out.println("Appel POST");
		System.out.println(ville.getNomCommune());
		villeBLOService.ajoutVille(ville);
			
	}
	
	// Methode PUT
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public void appelPut(@RequestBody Ville ville) {
		System.out.println("Appel PUT");
		System.out.println(ville.getNomCommune());
		villeBLOService.majVille(ville);
				
	}
	
	// Methode PUT
	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	@ResponseBody
	public void appelDelete(@RequestBody Ville ville) {
		System.out.println("Appel DELETE");
		System.out.println(ville.getNomCommune());
		villeBLOService.delVille(ville);			
	}
}
