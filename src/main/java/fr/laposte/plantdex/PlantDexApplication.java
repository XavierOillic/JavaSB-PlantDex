package fr.laposte.plantdex;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.laposte.plantdex.model.Plante;

@SpringBootApplication
public class PlantDexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantDexApplication.class, args);
	}
	
	@Bean
	ModelMapper getModelMapper() {
	return new ModelMapper();
	}
	

}
