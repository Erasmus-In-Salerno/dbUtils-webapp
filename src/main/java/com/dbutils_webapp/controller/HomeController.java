package com.dbutils_webapp.controller;

import com.dbutils_webapp.model.Animal;
import com.dbutils_webapp.repository.EntityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class HomeController {

    private final EntityRepository<Animal> repo;

    public HomeController(EntityRepository<Animal> repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("animals", repo.findAll());
        return "home";
    }

    @PostMapping("/addAnimal")
    public String addAnimal(@RequestParam("inputName") String name,
                          @RequestParam("inputAge") int age,
                          @RequestParam("inputSpecies") String species) {
        Animal animal = new Animal(name, age, species);
        repo.saveEntity(animal);
        return "redirect:/";
    }

    @PostMapping("/deleteAnimal")
    public String deleteAnimal(@RequestParam("id") Long id) {
        try{
            repo.deleteEntity(id);
            return "redirect:/";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
