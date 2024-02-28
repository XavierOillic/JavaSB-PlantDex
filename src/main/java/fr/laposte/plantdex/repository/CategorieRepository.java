package fr.laposte.plantdex.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.model.Plante;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	
	//List<Categorie>findByCategorieOrderBycategorie(Categorie categorie);
	//List<Categorie>findByCategorieorderByNom(Categorie categorie, String nom);
}
