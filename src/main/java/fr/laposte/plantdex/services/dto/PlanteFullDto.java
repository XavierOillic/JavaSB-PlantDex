package fr.laposte.plantdex.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.laposte.plantdex.model.Categorie;
import lombok.Data;

@Data
public class PlanteFullDto {
	
	private long id; // = UUID.randomUUID().toString();
	private String nom;
	private String soleil;
	private Integer arrosage;
	private String image;
	
	@JsonProperty("Categorie")
	private String categorieLibelle;
	//Parce que la Plante CONTIENT une Categorie
}
