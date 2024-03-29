package fr.laposte.plantdex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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

		@BeforeEach
		void cleanAndFeed() {
			planteRepo.deleteAll();
			categorieRepo.deleteAll();
			
			Categorie planteFleurie = categorieRepo.save(new Categorie("Plante Fleurie"));
			Categorie planteExterieur = categorieRepo.save(new Categorie("Plante Exterieure"));
			Categorie planteGrasse = categorieRepo.save(new Categorie("Plante Grasse"));
			Categorie planteInterieure = categorieRepo.save(new Categorie("Plante Interieure"));
			Categorie planteGrimpante = categorieRepo.save(new Categorie("Plante Grimpante"));
			
			categorieRepo.saveAll(Arrays.asList(planteFleurie, planteExterieur, planteGrasse, planteInterieure, planteGrimpante));
			
			Plante plante1 = new Plante("Rose", planteFleurie, Ensoleillement.BEAUCOUP, 3, "image.com");
			Plante plante2 = new Plante("Paquerette", planteExterieur , Ensoleillement.MOYEN, 3, "image.com");
			Plante plante3 = new Plante("Lys", planteGrasse, Ensoleillement.BEAUCOUP, 3, "image.com");
			Plante plante4 = new Plante("Olivier", planteInterieure, Ensoleillement.MOYEN, 3, "image.com");
			Plante plante5 = new Plante("Tournesol", planteGrimpante, Ensoleillement.PEU, 3, "image.com");
			Plante plante6 = new Plante("Laurier", planteGrimpante, Ensoleillement.PEU, 2, "image.com");
			Plante plante7 = new Plante("Palmier", planteGrasse, Ensoleillement.PEU, 2, "image.com");
			Plante plante8 = new Plante("Arôme", planteFleurie, Ensoleillement.MOYEN, 2, "image.com");
			
			planteRepo.saveAll(Arrays.asList(plante1, plante2, plante3, plante4, plante5, plante6, plante7, plante8));
		}
		
		@Test // ==> OK
		public void displayAllPlante() {
			for (Plante p : planteRepo.findAll()) {
			System.out.println(p);
			}
		
		} 
		@Test // ==> OK
		public void displayAllcat () {
			for (Categorie c : categorieRepo.findAll()) {
				System.out.println(c);
				}
		}
		
		@Test
		public void testsQueryPlanteRepo() {
			assertNotNull(planteRepo.findByNomEquals("Rose"));
			assertNull(planteRepo.findByNomEquals("roseline"));
			
		}
		@Test
		public void testfinByNom() {
			assertEquals("Paquerette", planteRepo.findByNomEquals("Paquerette").getNom());
			assertNotEquals("lys", planteRepo.findByNomEquals("lys").getNom());
			
			assertNotEquals(("rose"), planteRepo.findByNomEquals("Rose").getNom());
			assertNotEquals("1", planteRepo.findByNomEquals("Tournesol").getNom());
			
		}
		@Test
		public void testFindByNombis () {
			assertNotNull(planteRepo.findByNomEquals("rose"));
		}
		@Test
		public void testFindByEnsoleillement() {
			assertEquals(2, planteRepo.findBySoleil(Ensoleillement.BEAUCOUP).size());
			assertNotEquals(3, planteRepo.findBySoleil(Ensoleillement.BEAUCOUP).size());
			
			assertEquals(3, planteRepo.findBySoleil(Ensoleillement.PEU).size());
			assertNotEquals(4, planteRepo.findBySoleil(Ensoleillement.PEU).size());
		}
		
		@Test
		public void testFindByCategorie() {
			assertNotNull(categorieRepo.findByLibelle("Plante Fleurie"));
			assertNull(categorieRepo.findByLibelle("Plante"));
			
			
		}
		@Test
		public void testFindByCategorieNombre() {
			assertNotEquals("Plante Fleurie", categorieRepo.findByLibelle("Plante Fleurie"));
			
		}
		@Test
		public void testFindByLibelleOrderLibelle () {
			assertEquals("Plante Grimpante", categorieRepo.findByLibelleOrderByLibelle("Plante Grimpante").getLibelle());
			assertNotEquals("Plante Fleurie", categorieRepo.findByLibelleOrderByLibelle("Plante Grimpante").getLibelle());
			
		}
		
		@Test
		public void testFindBySoleilOrderBySoleil() {
			assertEquals(2, planteRepo.findBySoleilOrderBySoleil(Ensoleillement.BEAUCOUP).size());
			assertNotEquals(1, planteRepo.findBySoleilOrderBySoleil(Ensoleillement.PEU).size());
		}
		@Test
		public void testFindBySoleilLikeAndNom() {
			assertEquals(0, planteRepo.findBySoleilLikeAndNom(Ensoleillement.PEU, "Rose").size());
			assertNotEquals(1, planteRepo.findBySoleilLikeAndNom(Ensoleillement.PEU, "Rose").size());
			
			assertEquals(1, planteRepo.findBySoleilLikeAndNom(Ensoleillement.BEAUCOUP, "Lys").size());
			assertEquals(1, planteRepo.findBySoleilLikeAndNom(Ensoleillement.BEAUCOUP, "Rose").size());
			
		}
		@Test
		public void testFindByArrosageLikeAndNom() {
			assertEquals(0, planteRepo.findByArrosageAndNom(1, "Tournesol").size());
			assertNotEquals(1, planteRepo.findByArrosageAndNom(1, "Tournesol").size());
		}
		
}
