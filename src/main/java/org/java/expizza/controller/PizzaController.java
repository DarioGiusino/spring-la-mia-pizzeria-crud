package org.java.expizza.controller;

import java.util.List;

import org.java.expizza.pojo.Pizza;
import org.java.expizza.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String index(Model model){
		List<Pizza> pizzaList = pizzaService.findAll();
		
		model.addAttribute("pizzaList", pizzaList);

		return "pizza/index";
	}
}
