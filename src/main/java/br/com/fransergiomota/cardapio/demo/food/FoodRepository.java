package br.com.fransergiomota.cardapio.demo.food;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long>{
	
}
