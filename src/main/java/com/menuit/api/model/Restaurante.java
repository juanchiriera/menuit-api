package com.menuit.api.model;

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
