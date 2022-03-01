package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {
	
	@Autowired
	private MangaRepository repo;
	
	@GetMapping("/mangas")
	public String getAllMangas(Model model) {
		model.addAttribute("page", "Manga");
		
		List<Manga> mangas = (List<Manga>) repo.findAll();
		model.addAttribute("mangas", mangas);
		
		return "mangas";
	}
	
	@GetMapping("/coucou/{name}")
	public String hello(@PathVariable( value="name") String name, Model model) {
		
		Manga manga = new Manga();
		manga.setId(1);
		manga.setDescription("Une description");
		manga.setName("Un manga avec un titre de 3km de long");
		
		if (name.isBlank()) {
			name = "Wold";
		}
		
		model.addAttribute("manga", manga);
		model.addAttribute("nameControlleur", name);
		
		return "hello";
	}
}
