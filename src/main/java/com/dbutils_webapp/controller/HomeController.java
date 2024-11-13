package com.dbutils_webapp.controller;

import com.dbutils_webapp.model.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    List<Animal> animals =  new ArrayList<>();

    public HomeController() {
        animals.add(new Animal(1, "Peta", 13, "hawk"));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("animals", animals);
        return "home";
    }

    @PostMapping("/addAnimal")
    public String addAnimal(@RequestParam("inputName") String name,
                          @RequestParam("inputAge") int age,
                          @RequestParam("inputSpecies") String species) {
        int id = animals.isEmpty() ? 1 : animals.get(animals.size() - 1).id + 1;
        animals.add(new Animal(id, name, age, species));
        return "redirect:/";
    }

    @DeleteMapping("/deleteAnimal")
    public String deleteAnimal(@RequestParam("removeId") int id) {
        for (Animal animal : animals) {
            if (animal.id == id) {
                animals.remove(animal);
                break;
            }
        }
        return "redirect:/";
    }
}
