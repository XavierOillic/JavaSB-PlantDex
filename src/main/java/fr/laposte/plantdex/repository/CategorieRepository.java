package fr.laposte.plantdex.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.model.Plante;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	// Entre <> Toujours à gauche le Type de la Classe, et le Type Objet de l'ID (Integer, Long,..)
	
	Categorie findByLibelle(String libelle);
	
	Categorie findByLibelleOrderByLibelle(String categorie); //inutile : le ORDER ce quand il y en a plusieurs.
}
