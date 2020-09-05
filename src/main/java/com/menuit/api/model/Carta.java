package com.menuit.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Carta {
    @Id
    private long id;
    @DBRef
    private List<Categoria> categorias;
    @Transient
    public static final String SEQUENCE_NAME = "carta_sequence";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
}
