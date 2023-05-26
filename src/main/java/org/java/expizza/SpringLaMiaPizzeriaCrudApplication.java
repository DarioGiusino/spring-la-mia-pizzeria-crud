package org.java.expizza;

import org.java.expizza.pojo.Pizza;
import org.java.expizza.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pizza pizza1 = new Pizza("Margherita", "La bella Margherita", "https://picsum.photos/200/300", 9.99f);
		Pizza pizza2 = new Pizza("Diavola", "La bella Diavola", "https://picsum.photos/200/300", 10.99f);
		Pizza pizza3 = new Pizza("Napoli", "La bella Napoli", "https://picsum.photos/200/300", 11.99f);
		Pizza pizza4 = new Pizza("Parmigiana", "La bella Parmigiana", "https://picsum.photos/200/300", 12.99f);
		Pizza pizza5 = new Pizza("Biancaneve", "La bella Biancaneve", "https://picsum.photos/200/300", 13.99f);
		
		pizzaService.save(pizza1);
		pizzaService.save(pizza2);
		pizzaService.save(pizza3);
		pizzaService.save(pizza4);
		pizzaService.save(pizza5);
	}
}
