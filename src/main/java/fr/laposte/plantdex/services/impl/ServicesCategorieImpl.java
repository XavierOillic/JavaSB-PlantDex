package fr.laposte.plantdex.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.repository.CategorieRepository;
import fr.laposte.plantdex.services.ServicesCategorie;
import fr.laposte.plantdex.services.dto.CategorieFullDto;

@Service
public class ServicesCategorieImpl implements ServicesCategorie{
	
	@Autowired
	private CategorieRepository categorieRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	

	@Override
	public CategorieFullDto getOneById(long categorieId) {
		return modelMapper.map(categorieRepo.findById(categorieId), CategorieFullDto.class);
	}

	@Override
	public List<CategorieFullDto> ListCategories() {
		List<Categorie> categories = categorieRepo.findAll();
		// Je crée une première liste avec les categories normales.
		List<CategorieFullDto> ListDtoCat = categories.stream().map(c -> modelMapper.map(c, CategorieFullDto.class))
				.collect(Collectors.toList());
		// Je fais une liste DTO, et qu'elle est EGALE à categorie que je convertit grâce à MAP et MODELMAPPER.
		// Le " c " est une valeur arbitraire ITERATIVE.
		return ListDtoCat;
		
	}
	
	@Override
	public CategorieFullDto addCategory(CategorieFullDto dtoCategorie) {
		
		Categorie categorieAdded = modelMapper.map(dtoCategorie, Categorie.class);
		return modelMapper.map(categorieRepo.save(categorieAdded), CategorieFullDto.class);
				
	}
	
	@Override
	public CategorieFullDto updateCategory(CategorieFullDto categorie, Long categorieId) {
		
		Categorie categorieUpdated = modelMapper.map(categorie, Categorie.class);
		categorieUpdated.setId(categorieId);
		return modelMapper.map(categorieRepo.save(categorieUpdated), CategorieFullDto.class);
	}

	@Override
	@Transactional
	public void deletecategory(long categorieId) {
		categorieRepo.deleteById(categorieId);
		
	}





	

}
