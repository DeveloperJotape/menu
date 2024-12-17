package br.com.developerjotape.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.developerjotape.menu.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    
}
