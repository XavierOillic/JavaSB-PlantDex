package fr.laposte.plantdex.utilitaires;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.model.Ensoleillement;
import fr.laposte.plantdex.model.Plante;
import fr.laposte.plantdex.repository.CategorieRepository;
import fr.laposte.plantdex.repository.PlanteRepository;


@Component
// Je lui dit que cette classe peut être gérée par SB
public class InitiateDatas implements ApplicationRunner {
	
	/*  
	 * Cette classe est lancée en premier : elle me permet de lancer des options
	 * Par exemple : initialiser des datas pour qu'à l'affichage, il y ait qq 
	 * chose à voir
	 * Le IMPLEMENTS  appelle une Fonction de S.Boot
	 * Et me demande d'implementer cette méthode RUN
	 */
	
	@Autowired
	private PlanteRepository plantesRepo; // J'appele PlanteRepository
	
	@Autowired
	private CategorieRepository categorieRepo; // J'appele CategorieRepository pour pouvoir sauvegarder.

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*plantesRepo.deleteAll();
		categorieRepo.deleteAll();
		
		Categorie planteFleurie = categorieRepo.save(new Categorie("Plante Fleurie"));
		Categorie planteExterieur = categorieRepo.save(new Categorie("Plante Exterieure"));
		Categorie planteGrasse = categorieRepo.save(new Categorie("Plante Grasse"));
		Categorie planteInterieure = categorieRepo.save(new Categorie("Plante Interieure"));
		Categorie planteGrimpante = categorieRepo.save(new Categorie("Plante Grimpante"));
		Categorie Orchides = categorieRepo.save(new Categorie("Orchidés"));
		Categorie CactusEtPlantesGrasses = categorieRepo.save(new Categorie("Cactus & Plantes grasses"));
		Categorie Bonsai = categorieRepo.save(new Categorie("Bonsaï"));
		Categorie PlantesVertes = categorieRepo.save(new Categorie("Plantes Vertes"));
		Categorie PalmiersInterieur = categorieRepo.save(new Categorie("Palmiers d'Intérieur"));
		
		
		plantesRepo.save(new Plante("Edelweis", planteFleurie, Ensoleillement.BEAUCOUP, 1, "image.com"));
		plantesRepo.save(new Plante("Marguerite", planteExterieur, Ensoleillement.MOYEN, 2, "image.com"));
		plantesRepo.save(new Plante("Jonquille", planteGrasse, Ensoleillement.BEAUCOUP, 3, "image.com"));
		plantesRepo.save(new Plante("Arôm'atique", planteInterieure, Ensoleillement.MOYEN, 1, "image.com"));
		plantesRepo.save(new Plante("Yuka Yuka", planteGrimpante, Ensoleillement.PEU, 3, "image.com"));
		plantesRepo.save(new Plante("Olivier", planteGrimpante, Ensoleillement.PEU, 3, "image.com"));
		plantesRepo.save(new Plante("Rose", planteFleurie, Ensoleillement.PEU, 3, "image.com"));
		plantesRepo.save(new Plante("Orchidés", Orchides, Ensoleillement.BEAUCOUP, 2, "image.com"));
		plantesRepo.save(new Plante("cactus", CactusEtPlantesGrasses, Ensoleillement.BEAUCOUP, 2, "image.com"));
		plantesRepo.save(new Plante("Bonsaï", Bonsai, Ensoleillement.BEAUCOUP, 2, "image.com"));
		plantesRepo.save(new Plante("Arôme", PlantesVertes, Ensoleillement.BEAUCOUP, 2, "image.com"));
		plantesRepo.save(new Plante("Palmier d'interieur", PalmiersInterieur, Ensoleillement.BEAUCOUP, 2, "image.com"));
		
		
		for (Plante p : plantesRepo.findAll()) {
			System.out.println(p);
		}*/
		
	}

}
