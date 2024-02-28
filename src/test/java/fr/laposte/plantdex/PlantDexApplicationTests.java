package fr.laposte.plantdex;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.model.Ensoleillement;
import fr.laposte.plantdex.model.Plante;
import fr.laposte.plantdex.repository.CategorieRepository;
import fr.laposte.plantdex.repository.PlanteRepository;

@SpringBootTest
class PlantDexApplicationTests {

@Autowired
PlanteRepository planteRepo;

@Autowired
CategorieRepository categorieRepo;

@Autowired
private List<Plante>plante;
	
	@BeforeEach
	void cleanAndFeed() {
		
		planteRepo.deleteAll();
		/*plante.saveAll(Arrays.asList(plante1, plante2, plante3, plante4, plante5));*/
		
		}

		@Test
		public void tests() {
			
			Categorie planteFleurie = categorieRepo.save(new Categorie("Plante Fleurie"));
			Categorie planteExterieur = categorieRepo.save(new Categorie("Plante Exterieure"));
			Categorie planteGrasse = categorieRepo.save(new Categorie("Plante Grasse"));
			Categorie planteInterieure = categorieRepo.save(new Categorie("Plante Interieure"));
			Categorie planteGrimpante = categorieRepo.save(new Categorie("Plante Grimpante"));
			
			
			Plante plante1 = new Plante("Rose", planteFleurie, Ensoleillement.BEAUCOUP, 3, "image.com");
			Plante plante2 = new Plante("Paquerette", planteExterieur , Ensoleillement.MOYEN, 3, "image.com");
			Plante plante3 = new Plante("Lys", planteGrasse, Ensoleillement.BEAUCOUP, 3, "image.com");
			Plante plante4 = new Plante("Olivier", planteInterieure, Ensoleillement.MOYEN, 3, "image.com");
			Plante plante5 = new Plante("Tournesol", planteGrimpante, Ensoleillement.PEU, 3, "image.com");
			plante.add(plante1);
			plante.add(plante2);
			plante.add(plante3);
			plante.add(plante4);
			plante.add(plante5);
			
			for (Plante pl : plante) {
				System.out.println(pl);
		}
			
			
	}
}
