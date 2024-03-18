package fr.laposte.plantdex.services.dto;

import fr.laposte.plantdex.model.Categorie;

public class PlanteFullDto {
	
	private long id; // = UUID.randomUUID().toString();
	private String nom;
	private Categorie categorie;
	private String soleil;
	private Integer arrosage;
	private String image;

}
