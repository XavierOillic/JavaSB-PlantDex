package fr.laposte.plantdex.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/*@org.springframework.beans.factory.annotation.Autowired(required=true)*/

@Entity
@Data
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@RequiredArgsConstructor

public class Categorie {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	@Column(unique = true)
	private String libelle;

}
