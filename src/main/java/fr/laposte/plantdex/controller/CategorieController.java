package fr.laposte.plantdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.repository.CategorieRepository;

@RestController
@RequestMapping("/controller/categorie")
public class CategorieController {
	
	@Autowired
	private CategorieRepository categorieRepo;
	
	@GetMapping
	public List<Categorie> getAll(){
		return categorieRepo.findAll();
		
	}

}
