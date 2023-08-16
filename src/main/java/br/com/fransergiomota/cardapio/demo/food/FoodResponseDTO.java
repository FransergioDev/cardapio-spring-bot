package br.com.fransergiomota.cardapio.demo.food;

public record FoodResponseDTO (Long id, String title, String image, Integer price) {
	public FoodResponseDTO(FoodEntity food) {
		this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
	}
	public FoodResponseDTO(Long id, String title, String image, Integer price) {
		this.price = price;
		this.image = image;
		this.title = title;
		this.id = id;
	}
}
