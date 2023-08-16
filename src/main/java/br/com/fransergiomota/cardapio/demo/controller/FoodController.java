package br.com.fransergiomota.cardapio.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fransergiomota.cardapio.demo.food.FoodEntity;
import br.com.fransergiomota.cardapio.demo.food.FoodRepository;
import br.com.fransergiomota.cardapio.demo.food.FoodRequestDTO;
import br.com.fransergiomota.cardapio.demo.food.FoodResponseDTO;

@RestController
@RequestMapping("food")
public class FoodController {
	
	@Autowired // Injeção de dependêcia
	private FoodRepository repository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public ResponseEntity<List<FoodResponseDTO>> getAll() {
		List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
		return ResponseEntity.ok(foodList);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public ResponseEntity<FoodEntity> saveFood(@RequestBody @Validated FoodRequestDTO data, UriComponentsBuilder uriBuilder) {
		FoodEntity foodData = new FoodEntity(data);
		repository.save(foodData);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(foodData.getId()).toUri();
		return ResponseEntity.created(uri).body(foodData);
	}
}