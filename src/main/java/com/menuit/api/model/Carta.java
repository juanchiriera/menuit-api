package com.menuit.api.model;

import javax.persistence.*;
import java.util.List;

public class Carta {
    private int id;

    private List<Categoria> categorias;

    public void setId(int id) {
        this.id = id;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public int getId() {
        return id;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
}
