package br.com.developerjotape.menu.entity.dto;

import br.com.developerjotape.menu.entity.Food;

public record FoodRequestDTO (String name, String image, Integer price) {
    public FoodRequestDTO(Food food) {
        this(food.getName(), food.getImage(), food.getPrice());
    }
    
}
