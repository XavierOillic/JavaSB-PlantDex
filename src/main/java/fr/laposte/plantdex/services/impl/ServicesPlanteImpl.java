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
		
		Plante planteAdded = modelMapper.map(dtoPlante, Plante.class);
		
		planteAdded.setCategorie(categorie);
		
		return modelMapper.map(planteRepo.save(planteAdded), PlanteFullDto.class);
	}

	@Override
	public PlanteFullDto updatePlante(PlanteFullDto plante, Long planteId) {
		Plante planteUpdated = modelMapper.map(plante, Plante.class);
		planteUpdated.setId(planteId);
		return modelMapper.map(planteRepo.save(planteUpdated), PlanteFullDto.class);
	}

	@Override
	public void deletePlante(Long planteId) {
		planteRepo.deleteById(planteId);
		// Je n'utilise pas le DTO car je DELETE. Seul le REPO est nécessaire.
		
	}
	
	

}
