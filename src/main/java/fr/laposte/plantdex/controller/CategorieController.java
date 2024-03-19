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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/controller/categorie")
public class CategorieController {
	
	@Autowired
	private CategorieRepository categorieRepo;
	
	@Autowired 
	private ServicesCategorie servicesCateg;
	
	// GET ALL the CATEGORIES ==> testée Postman OK 
	@GetMapping
	public List<CategorieFullDto> getAll(){
		return servicesCateg.ListCategories();
	}
	
	// GET ONE BY ID. ==> testée Postman OK
	@GetMapping("/{categorieId}")
	public CategorieFullDto getOne(@PathVariable long categorieId) {
		CategorieFullDto result = servicesCateg.getOneById(categorieId);
		if (result == null) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return result;
		
	}
	
	// POST by ID ==> Ajout 
	@PostMapping
	public void addOne(@RequestBody @Valid CategorieFullDto categorie) {
		servicesCateg.addCategory(categorie);
		
	}
	
	// PUT by ID ==> Modification
	//Je fais appel au SERVICE GETbyID d'abord, Pour modifier ladite Catégorie.
	// Je verifie que cet ID existe bien, sinon, j'envoie une erreur NOT_FOUND.
	@PutMapping("/{categorieId}")
	public void update(@PathVariable Long categorieId, @RequestBody @Valid CategorieFullDto categoryUpdate) {
		if (servicesCateg.getOneById(categorieId)== null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				servicesCateg.updateCategory(categoryUpdate, categorieId);
	}
	
	// DELETE by ID ==> Suppréssion.
	@DeleteMapping("/{categorieId}")
	public void deleteById(@PathVariable Long categorieId) {
		if (servicesCateg.getOneById(categorieId)== null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				servicesCateg.deletecategory(categorieId);
	}

}
