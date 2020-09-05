package com.menuit.api;

import com.menuit.api.model.Carta;
import com.menuit.api.model.Categoria;
import com.menuit.api.model.Item;
import com.menuit.api.model.Restaurante;
import com.menuit.api.repository.*;
import com.menuit.api.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController(value = "/api")
public class ApiController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired RestauranteRepository restauranteRepository;
    @Autowired SequenceGeneratorRepository sequenceGeneratorRepository;
    @Autowired CartaRepository cartaRepository;
    @Autowired CategoriaRepository categoriaRepository;
    @Autowired ItemRepository itemRepository;
    @Autowired SequenceGeneratorService sqService;

    /*-----RESTAURANTES------*/
    @PostMapping(value = "/restaurantes")
    public void nuevoRestaurante(@RequestBody Restaurante restaurante) {
        guardarRestaurante(restaurante);
    }

    @PutMapping(value = "/restaurantes/{id}")
    public void updateRestaurante(@RequestBody Restaurante restaurante, @PathVariable String id) {
        //Optional<Restaurante> restauranteU = restauranteRepository.findById(Long.parseLong(id));
        //TODO: Verificar como llega el dato
        guardarRestaurante(restaurante);

    }

    @GetMapping("/restaurante/{nombre}")
    public Restaurante getRestaurante(@PathVariable String nombre) {
        return restauranteRepository.findByNombre(nombre);
    }

    @GetMapping("/restaurantes/{id}")
    public Restaurante getRestauranteById(@PathVariable String id) {
        return restauranteRepository.findById(Long.parseLong(id)).orElse(new Restaurante());
    }

    @GetMapping(value = "/restaurantes")
    public ResponseEntity<List<Restaurante>> getAllRestaurants() {
        List<Restaurante> restaurantes = restauranteRepository.findAll();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", Integer.toString(restaurantes.size()));
        return ResponseEntity.ok().headers(responseHeaders)
                .body(restaurantes);
    }

    @DeleteMapping("/restaurantes/{id}")
    public void deleteRestaurante(@PathVariable String id){
        restauranteRepository.deleteById(id);
    }

    /*-----CATEGORIAS------*/
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getCategoriaByRestaurante(@RequestParam(required=false) String restauranteId){
        List<Categoria> categorias;
        if(restauranteId != null) {
            Optional<Restaurante> restaurante = restauranteRepository.findById(Integer.parseInt(restauranteId));
            categorias = restaurante.orElse(new Restaurante()).getCategorias();
        }else{
            categorias = categoriaRepository.findAll();
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", Integer.toString(categorias.size()));
        return ResponseEntity.ok().headers(responseHeaders).body(categorias);
    }

    @GetMapping("/categorias/{id}")
    public Categoria getCategoriaById(@PathVariable String id) {
        return categoriaRepository.findById(Long.parseLong(id)).orElse(new Categoria());
    }

    @PostMapping(value = "/categorias")
    public void nuevaCategoria(@RequestBody Categoria categoria) {
        Restaurante restaurante = restauranteRepository.findById(Long.parseLong(categoria.getRestauranteId())).orElse(new Restaurante());
        if(restaurante.getId()!=null){
            restaurante.addCategoria(categoria);
            guardarRestaurante(restaurante);
        }
    }

    @PutMapping(value = "/categorias/{id}")
    public void updateCategoria(@RequestBody Categoria categoria, @PathVariable String id) {
        //TODO: Verificar como llega el dato
        guardarCategoria(categoria);
    }

    @DeleteMapping("/categorias/{id}")
    public void deleteCategoria(@PathVariable String id){
        categoriaRepository.deleteById(id);
    }

    /*------ITEMS------*/
    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItemByCategoria(@RequestParam(required=false) String categoriaId){
        List<Item> items;
        if(categoriaId != null) {
            Optional<Categoria> categoria = categoriaRepository.findById(Long.parseLong(categoriaId));
            items = categoria.orElse(new Categoria()).getItems();
        }else{
            items = itemRepository.findAll();
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", Integer.toString(items.size()));
        return ResponseEntity.ok().headers(responseHeaders).body(items);
    }

    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable String id) {
        return itemRepository.findById(Long.parseLong(id)).orElse(new Item());
    }

    @PostMapping(value = "/items")
    public void nuevoItem(@RequestBody Item item) {
        Categoria categoria = categoriaRepository.findById(Long.parseLong(item.getCategoriaId())).orElse(new Categoria());
        if(categoria.getId()!=null){
            categoria.addItem(item);
            guardarCategoria(categoria);
        }
    }

    @PutMapping(value = "/items/{id}")
    public void updateItem(@RequestBody Item item, @PathVariable String id) {
        //TODO: Verificar como llega el dato
        guardarItem(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable String id){
        itemRepository.deleteById(id);
    }



    private void guardarCategoria(Categoria categoria) {
        if(categoria.getItems()!=null) {
            for (Item item : categoria.getItems()) {
                guardarItem(item);
            }
        }
        if(categoria.getId()==null) {
            categoria.setId(sqService.generateSequence(Categoria.SEQUENCE_NAME));
        }
        categoriaRepository.save(categoria);
    }

    private void guardarItem(Item item) {
        if(item.getId() == null) {
            item.setId(sqService.generateSequence(Item.SEQUENCE_NAME));
        }
        itemRepository.save(item);
    }


    private void guardarRestaurante(Restaurante restaurante) {
        if (restaurante.getCategorias() != null) {
            for (Categoria categoria :
                    restaurante.getCategorias()) {
                guardarCategoria(categoria);
            }
        }
        if(restaurante.getId()==null) {
            restaurante.setId(sqService.generateSequence(Restaurante.SEQUENCE_NAME));
        }
        restauranteRepository.save(restaurante);
    }
}
