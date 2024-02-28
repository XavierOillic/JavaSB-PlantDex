package fr.laposte.plantdex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.model.Plante;

public interface PlanteRepository extends JpaRepository<Plante, Long>{
	
	/*List<Plante>findByNomOrderByNom(String nomExact); /* QUERY METHOD */
	/*List<Plante>findByCategorieOrderByNom(Categorie categorie, String nom);*/

}
