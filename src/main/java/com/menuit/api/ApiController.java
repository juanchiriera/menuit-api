package com.menuit.api;

import com.menuit.api.model.Restaurante;
import com.menuit.api.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/api")
public class ApiController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    RestauranteRepository restauranteRepository;

    @PutMapping(value = "/restaurante")
    public void nuevoRestaurante(@RequestBody Restaurante restaurante){
        restauranteRepository.save(restaurante);
    }

    @GetMapping("/restaurante/{nombre}")
    public Restaurante getRestaurante(@PathVariable String nombre){
        return restauranteRepository.findByNombre(nombre);
    }

    @GetMapping(value = "/restaurantes")
    public List<Restaurante> getAllRestaurants(){
        return restauranteRepository.findAll();
    }

}
