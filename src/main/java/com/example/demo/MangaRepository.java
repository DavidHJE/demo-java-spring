package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MangaRepository extends CrudRepository<Manga, Long> {

	List<Manga> findByName(String name);
	
	Manga findById(int id);
	
	List<Manga> findByNameOrderByNameDesc(String name);
}
