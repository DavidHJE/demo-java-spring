package com.example.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestControlleur {
	
	@Autowired
	private MangaRepository repository;
	
	@GetMapping("/api/mangas")
	public Iterable<Manga> getManga() {
		return repository.findAll();
	}
	
	@GetMapping("/api/generate")
	public void generate() {
			for (int i = 1; i <= 10; i++) {
				Manga manga = new Manga("Manga " + i);
				manga.setDescription("une description du manga " + i);
				
				repository.save(manga);
			}
	}
	
}
