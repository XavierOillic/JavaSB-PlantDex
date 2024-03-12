package fr.laposte.plantdex.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.model.Plante;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	
	List<Categorie>findByLibelle(String libelle);
	List<Categorie>findByLibelleOrderByLibelle(String categorie);
}
