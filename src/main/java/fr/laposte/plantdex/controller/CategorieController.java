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
import fr.laposte.plantdex.repository.CategorieRepository;
import fr.laposte.plantdex.services.ServicesCategorie;
import fr.laposte.plantdex.services.dto.CategorieFullDto;

@RestController
@RequestMapping("/controller/categorie")
public class CategorieController {
	
	@Autowired
	private CategorieRepository categorieRepo;
	
	@Autowired 
	private ServicesCategorie servicesCateg;
	
	@GetMapping
	public List<CategorieFullDto> getAll(){
		return servicesCateg.ListCategories();
	}
	
	@GetMapping("/{categorieId}")
	public CategorieFullDto getOne(@PathVariable long categorieId) {
		CategorieFullDto result = servicesCateg.getOneById(categorieId);
		if (result == null) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return result;
		
	}
	
	@PostMapping("{id}")
	public void addOne(@RequestBody Categorie categorie) {
		categorieRepo.save(categorie);
		
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Long categorieId, @RequestBody Categorie categorieUpdate) {
		Categorie categorie = categorieRepo.findById(categorieId).orElseThrow();
		categorieRepo.delete(categorie);
		
		categorie.setLibelle(categorieUpdate.getLibelle());
		categorieRepo.save(categorie);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long categorieId) {
		categorieRepo.deleteById(categorieId);
	}

}
