package com.menuit.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document
public class Categoria {
    @Id
    private Long id;
    private String nombre;
    @DBRef
    private List<Item> items;
    @Transient
    public static final String SEQUENCE_NAME = "categoria_sequence";
    @Transient
    private String restauranteId;

    public Long getId() {
        return id;
    }

    public String getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(String restauranteId) {
        this.restauranteId = restauranteId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        if(this.items == null)
            this.items = new ArrayList<>();
        this.items.add(item);
    }

}
