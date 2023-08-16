package br.com.fransergiomota.cardapio.demo.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import br.com.fransergiomota.cardapio.demo.food.FoodEntity;
import br.com.fransergiomota.cardapio.demo.food.FoodRepository;
import io.restassured.http.ContentType;

/*
 * Como a classe fornece vários métodos estáticos essa importação abaixo torna 
 * possível acessar tais de forma mais rápida e direta como se fossem métodos estáticos dessa classe.
 * */
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*; 

@WebMvcTest
public class FoodControllerTest {
	@Autowired
	private FoodController foodController;
	
	@MockBean
	private FoodRepository repository; // Cria um mock do respository para não chamar ele de fato
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.foodController);
	}

	@Test
	public void deveRetornarSucesso_QuandoBuscarComidas() {
		List<FoodEntity> foodList = new ArrayList<FoodEntity>();
		
		foodList.add(new FoodEntity(1L, "Pizza Grande Portuguesa", "", 55));
		foodList.add(new FoodEntity(2L, "Pizza Pequena Chocolate", "", 58));
		foodList.add(new FoodEntity(3L, "Coca-cola 2L", "", 8));
		
		when(this.repository.findAll()).thenReturn(foodList);
		
		given()
			.accept(ContentType.JSON)
			.when().get("/food")
			.then()
			.statusCode(HttpStatus.OK.value());
	}
}
