package br.com.developerjotape.menu.entity.dto;

import br.com.developerjotape.menu.entity.Food;

public record FoodResponseDTO(Long id, String name, String image, Integer price) {
    public FoodResponseDTO(Food food) {
        this(food.getId(), food.getName(), food.getImage(), food.getPrice());
    }
}
