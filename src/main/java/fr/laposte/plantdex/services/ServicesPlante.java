package fr.laposte.plantdex.services;

import java.util.List;


import fr.laposte.plantdex.services.dto.PlanteFullDto;

public interface ServicesPlante {
	
	List<PlanteFullDto>ListPlante();
	
	PlanteFullDto getOneById (Long planteId);
	
	PlanteFullDto addPlante(PlanteFullDto plante);
	
	PlanteFullDto updatePlante(PlanteFullDto plante, Long planteId);
	
	void deletePlante (Long planteId);

}
