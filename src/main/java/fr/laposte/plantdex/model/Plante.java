package fr.laposte.plantdex.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class Plante {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id; // = UUID.randomUUID().toString();
	
	@NonNull
	@Column(unique = true)
	private String nom;
	
	@ManyToOne /* Une plante n'appartient qu'à UNE CATEGORIE mais UNE categorie CONTIENT PLUSIEURS PLANTE */
	@NonNull
	private Categorie categorie;
	
	@Enumerated(EnumType.STRING)
	@NonNull
	private Ensoleillement soleil;
	
	@NonNull
	private Integer arrosage;
	
	@NonNull
	private String image;
	
}
