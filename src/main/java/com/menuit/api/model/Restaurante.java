package com.menuit.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Restaurante {
    @Id
    private Long id;
    private String nombre;
    @DBRef
    private List<Categoria> categorias;

    @Transient
    public static final String SEQUENCE_NAME = "restaurante_sequence";

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }


    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getId(){
        return this.id;
    }

    public void addCategoria(Categoria categoria) {
        if(this.categorias == null)
            categorias = new ArrayList<>();
        categorias.add(categoria);
    }
}
