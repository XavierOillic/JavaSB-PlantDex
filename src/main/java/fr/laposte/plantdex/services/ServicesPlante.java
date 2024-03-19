package fr.laposte.plantdex.services;

import java.util.List;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.services.dto.PlanteFullDto;

public interface ServicesPlante {
	
	List<PlanteFullDto>listPlante();
	
	PlanteFullDto getOneById (Long planteId);
	
	PlanteFullDto addPlante(PlanteFullDto plante);
	
	PlanteFullDto updatePlante(PlanteFullDto plante, Long planteId);
	
	void deletePlante (Long planteId);
	
	List<PlanteFullDto>searchByWatering();
	List<PlanteFullDto>searchBySunshine();
	List<PlanteFullDto>searchBycategory();
	List<PlanteFullDto>searchByKeyWords();
	List<PlanteFullDto>searchAllPlant();

}
