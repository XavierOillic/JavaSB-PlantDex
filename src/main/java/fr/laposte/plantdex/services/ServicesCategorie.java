package fr.laposte.plantdex.services;

import java.util.List;

import fr.laposte.plantdex.services.dto.CategorieFullDto;

public interface ServicesCategorie {
	
	List<CategorieFullDto>ListCategories();
	
	CategorieFullDto getOneById(long categorieId);
	
	CategorieFullDto addCategory(CategorieFullDto categorie);
	
	CategorieFullDto updateCategorie(CategorieFullDto categorie, long categorieId);
	
	void deletecategorie(long categorieId);

}
