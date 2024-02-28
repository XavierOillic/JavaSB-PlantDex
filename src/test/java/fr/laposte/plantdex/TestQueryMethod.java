package fr.laposte.plantdex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.plantdex.repository.CategorieRepository;
import fr.laposte.plantdex.repository.PlanteRepository;



@SpringBootTest
public class TestQueryMethod {
	
	@Autowired
	private CategorieRepository categorieRepo;
	@Autowired
	private PlanteRepository planteRepo;

}
