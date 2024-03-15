package fr.laposte.plantdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.model.Plante;
import fr.laposte.plantdex.repository.CategorieRepository;
import fr.laposte.plantdex.repository.PlanteRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/controller/plante")
@Log4j2

public class PlanteController {
	
	@Autowired
	private PlanteRepository planteRepo;
	
	@Autowired
	private CategorieRepository categorieRepo;
	
	@GetMapping
	public List<Plante> getAll(){
		return planteRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Plante getOne(@PathVariable Long id) {
		return planteRepo.findById(id).orElseThrow();
	}
	
	@PostMapping
	public void add(@RequestBody Plante plante, @RequestParam Long categorieId) {
		log.info("Create : " + plante, plante, plante, plante, plante, plante, plante, plante);
		Categorie categorie = categorieRepo.findById(categorieId).orElseThrow();
		plante.setCategorie(categorie);
		planteRepo.save(plante);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		planteRepo.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void update (@PathVariable Long planteId, @RequestBody Plante planteUpdate) {
		Plante plante = planteRepo.findById(planteId).orElseThrow();
		log.info("Create : " + plante, plante, plante, plante, plante, plante, planteUpdate, plante);
		planteRepo.delete(plante);
		
		plante.setNom(planteUpdate.getNom());
		plante.setCategorie(planteUpdate.getCategorie());
		plante.setSoleil(planteUpdate.getSoleil());
		plante.setArrosage(planteUpdate.getArrosage());
		plante.setImage(planteUpdate.getImage());
		
		
		log.info("New : "+ plante);
		planteRepo.save(plante);
		
	}
	/*
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
