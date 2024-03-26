package fr.laposte.plantdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.model.Ensoleillement;
import fr.laposte.plantdex.model.Plante;
import fr.laposte.plantdex.repository.CategorieRepository;
import fr.laposte.plantdex.repository.PlanteRepository;
import fr.laposte.plantdex.services.ServicesCategorie;
import fr.laposte.plantdex.services.ServicesPlante;
import fr.laposte.plantdex.services.dto.PlanteFullDto;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/controller/plante")
public class PlanteController {
	
	@Autowired private PlanteRepository planteRepo;
	@Autowired private CategorieRepository categorieRepo;
	
	@Autowired private ServicesCategorie serviceCateg;
	@Autowired private ServicesPlante servicePlante;
	
	
// GET ALL, je liste toutes les plantes.	
	@GetMapping
	public List<PlanteFullDto> getAll(){
		return servicePlante.listPlante();
	}

// GETBYID, j'en choisi UNE a afficher.
	@GetMapping("/{planteId}")
	public PlanteFullDto getOne(@PathVariable Long planteId) {
		PlanteFullDto result = servicePlante.getOneById(planteId);
		if (result == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return result;
	}

// ADD
	@PostMapping
	public void addOne(@RequestBody PlanteFullDto planteAdded) {
		servicePlante.addPlante(planteAdded);	
	}
	
	@PutMapping("/{planteId}")
	public void update (@PathVariable Long planteId, @RequestBody PlanteFullDto planteUpdate) {
		if (servicePlante.getOneById(planteId) == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				servicePlante.updatePlante(planteUpdate, planteId);	
	}
	
// DELETE ===> SUPPRESSION	
	@DeleteMapping("/{planteId}")
	public void delete(@PathVariable Long planteId) {
		if (servicePlante.getOneById(planteId)== null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				servicePlante.deletePlante(planteId);
	}
	/*
	
	 * 
	@GetMapping
	public List<Plante> getAll(@RequestParam(required = false) Integer arrosage) {
		List<Plante> result = null;
		if (arrosage == null) {
			result = planteRepo.findAll();
		}else {
			result = planteRepo.findByNomEquals("Rose");
		}
		return result;
		
	}
	
	
	*/

}
