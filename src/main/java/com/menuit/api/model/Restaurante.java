package com.menuit.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class Restaurante {
    private int id;
    private String nombre;
    private Carta carta;

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Carta getCarta(){
        return carta;
    }

    public void setCarta(Carta carta){
        this.carta = carta;
    }
}
