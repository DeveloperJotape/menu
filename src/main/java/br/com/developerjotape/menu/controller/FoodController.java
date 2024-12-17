package br.com.developerjotape.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.developerjotape.menu.entity.dto.FoodRequestDTO;
import br.com.developerjotape.menu.entity.dto.FoodResponseDTO;
import br.com.developerjotape.menu.service.FoodService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/saveFood")
    public ResponseEntity<FoodResponseDTO> saveFood(@RequestBody @Valid FoodRequestDTO foodRequestDTO) {
        var food = foodService.saveFood(foodRequestDTO);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @SuppressWarnings("null")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getAll")
    public ResponseEntity<List<FoodResponseDTO>> getAll() {
        try{
            List<FoodResponseDTO> foodList = foodService.getAll();
            if (foodList.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);     
            }
            return new ResponseEntity<>(foodList, HttpStatus.OK); 
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        
    }

}
