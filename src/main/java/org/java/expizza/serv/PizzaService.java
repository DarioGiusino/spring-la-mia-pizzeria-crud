package org.java.expizza.serv;

import java.util.List;
import java.util.Optional;

import org.java.expizza.pojo.Pizza;
import org.java.expizza.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class PizzaService {
	
	@Autowired
	PizzaRepo pizzaRepo;
	
	public List<Pizza> findAll() {
		
		return pizzaRepo.findAll();
	}
	public Pizza save(Pizza pizza) {
		
		return pizzaRepo.save(pizza);
	}
	public Optional<Pizza> findById(int id) {
		
		return pizzaRepo.findById(id);
	}
}
