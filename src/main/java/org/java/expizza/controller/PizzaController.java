package org.java.expizza.controller;

import java.util.List;
import java.util.Optional;

import org.java.expizza.pojo.Pizza;
import org.java.expizza.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/pizza/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		
		Optional<Pizza> pizzaOpt = pizzaService.findById(id);
		
		Pizza pizza = pizzaOpt.get();
		
		model.addAttribute("pizza", pizza);
		
		return "pizza/show";
	}
	
	@PostMapping("/pizza/filter")
	public String filterPizza(Model model, @RequestParam(required = false) String name) {
		
		List<Pizza> pizzaList = pizzaService.findByName(name);
		model.addAttribute("pizzaList", pizzaList);
		model.addAttribute("name", name);
		
		return "pizza/index";
	}
	
	@GetMapping("/pizza/create")
	public String create() {
		
		return "pizza/create";
	}
	
	@PostMapping("/pizza/store")
	public String store(@ModelAttribute Pizza pizza){
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		
		Optional<Pizza> pizzaOpt = pizzaService.findById(id);
		Pizza pizza = pizzaOpt.get();
		
		model.addAttribute("pizza", pizza);
		
		return "pizza/edit";
	}
	
	@PostMapping("pizza/update/{id}")
	public String update(@PathVariable("id") int id, @ModelAttribute Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("pizza/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		
		Optional<Pizza> pizzaOpt = pizzaService.findById(id);
		Pizza pizza = pizzaOpt.get();
		
		pizzaService.delete(pizza);
		
		return "redirect:/";
	}
}
