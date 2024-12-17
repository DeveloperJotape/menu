package br.com.developerjotape.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.developerjotape.menu.entity.Food;
import br.com.developerjotape.menu.entity.dto.FoodRequestDTO;
import br.com.developerjotape.menu.entity.dto.FoodResponseDTO;
import br.com.developerjotape.menu.repository.FoodRepository;

@Service
public class FoodService {

     @Autowired
     private FoodRepository foodRepository;

     public FoodResponseDTO saveFood(FoodRequestDTO foodRequestDTO) {
          Food food = new Food(foodRequestDTO);
          foodRepository.save(food);
          return new FoodResponseDTO(food);
     }

     public List<FoodResponseDTO> getAll() {
          return this.foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
     }

}
