package fr.laposte.plantdex.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.model.Plante;
import fr.laposte.plantdex.repository.CategorieRepository;
import fr.laposte.plantdex.repository.PlanteRepository;
import fr.laposte.plantdex.services.ServicesPlante;
import fr.laposte.plantdex.services.dto.CategorieFullDto;
import fr.laposte.plantdex.services.dto.PlanteFullDto;

@Service
public class ServicesPlanteImpl implements ServicesPlante {
	
	@Autowired PlanteRepository planteRepo;
	@Autowired CategorieRepository categorieRepo;
	
	@Autowired ModelMapper modelMapper;

	@Override
	public List<PlanteFullDto> listPlante() {
		List<Plante>plantesAll = planteRepo.findAll(); // Je crée une List normale de Plante.
		List<PlanteFullDto>plantesAllDto = plantesAll.stream().map(p -> modelMapper.map(p, PlanteFullDto.class))
				.collect(Collectors.toList());
		// Je transforme cette List initiale en List DTO grace au PARCOURS de STREAM, et grâce au MAP, je fais la même chose sur chaque élément;
		return plantesAllDto;
	}

	@Override
	public PlanteFullDto getOneById(Long planteId) {
		return modelMapper.map(planteRepo.findById(planteId), PlanteFullDto.class);
		// Je transforme la planteID trouvée via l'ID par le Repo en DTO.
	}

	@Override
	public PlanteFullDto addPlante(PlanteFullDto dtoPlante) {
		
		Categorie categorie = categorieRepo.findByLibelle(dtoPlante.getCategorieLibelle());
		// Je récupère(FIND) avec la Categorie/cateRepo par le DTO et le GET (CategorieLIbelle du DTO PLante)
		
		Plante planteAdded = modelMapper.map(dtoPlante, Plante.class);
		// Je mappe la plante normale sur la plante DTO
		
		planteAdded.setCategorie(categorie);
		// Je SET la Categorie.
		
		return modelMapper.map(planteRepo.save(planteAdded), PlanteFullDto.class);
		// Je MAP, et je SAVE la PLANTEADDED dans la meme ligne.
	}

	@Override
	public PlanteFullDto updatePlante(PlanteFullDto dtoPlante, Long planteId) {
		
		Categorie categorie = categorieRepo.findByLibelle(dtoPlante.getCategorieLibelle());
		Plante planteUpdated = planteRepo.findById(planteId).orElseThrow();
		// En entrée de Méthode : l'ID et la CATEGORIE.
		
		planteUpdated = modelMapper.map(dtoPlante, Plante.class);
		// Je transforme le DTO  PLANTE, en Plante normale.
		planteUpdated.setCategorie(categorie);
		planteUpdated.setId(planteId);
		// je modifie la Catégorie et l'id.
		
		return modelMapper.map(planteRepo.save(planteUpdated), PlanteFullDto.class);
		// je sauve grace au Repo, et je transforme planteUpdated type Plante en Type DTO
		
	}

	@Override
	public void deletePlante(Long planteId) {
		planteRepo.deleteById(planteId);
		// Je n'utilise pas le DTO car je DELETE. Seul le REPO est nécessaire.
		
	}

	@Override
	public List<PlanteFullDto> searchByWatering() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanteFullDto> searchBySunshine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanteFullDto> searchBycategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanteFullDto> searchByKeyWords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanteFullDto> searchAllPlant() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
