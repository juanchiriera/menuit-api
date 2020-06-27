package com.menuit.api;

import com.menuit.api.model.Restaurante;
import com.menuit.api.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/api")
public class ApiController {
    @Autowired
    RestauranteRepository restauranteRepository;

    @PutMapping(value = "/restaurante")
    public void nuevoRestaurante(@RequestBody Restaurante restaurante){
        restauranteRepository.save(restaurante);
    }

    @GetMapping("/restaurante/{nombre}")
    public void getRestaurante(@PathVariable String nombre){
        restauranteRepository.
    }

    @GetMapping(value = "/restaurantes")
    public List<Restaurante> getAllRestaurants(){
        return restauranteRepository.findAll();
    }

}
