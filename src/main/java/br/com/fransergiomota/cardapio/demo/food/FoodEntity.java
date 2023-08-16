package br.com.fransergiomota.cardapio.demo.food;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "foods")
@Entity(name = "foods")
/*
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")*/
public class FoodEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String image;
	private Integer price;
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public FoodEntity(Long id, String title, String image, Integer price) {
		this.price = price;
		this.image = image;
		this.title = title;
		this.id = id;
	}
	
	public FoodEntity(FoodRequestDTO data) {
		this.title = data.title();
		this.image = data.image();
		this.price = data.price();
	}
}
