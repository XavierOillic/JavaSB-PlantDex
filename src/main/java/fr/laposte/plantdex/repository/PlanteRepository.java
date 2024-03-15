package fr.laposte.plantdex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.model.Ensoleillement;
import fr.laposte.plantdex.model.Plante;

public interface PlanteRepository extends JpaRepository<Plante, Long>{
	
	Plante findByNomEquals(String nomExact); /* QUERY METHOD */
	
	List<Plante>findBySoleil(Ensoleillement soleil);
	
	List<Plante>findBySoleilOrderBySoleil(Ensoleillement soleil);
	
	List<Plante>findBySoleilLikeAndNom(Ensoleillement soleil, String nomExact);
	
	List<Plante>findByArrosageAndNom(int arrosage, String nomExact);

}
