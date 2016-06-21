package com.juanjosegallego.lineasalud;

public class Lista_Entrada {

    int idimagen;
    String nombre,pila,fecha;

    public Lista_Entrada(int idimagen, String nombre, String pila, String fecha) {
        this.idimagen = idimagen;
        this.nombre = nombre;
        this.pila = pila;
        this.fecha = fecha;
    }

    public Lista_Entrada(int lsu, String s, String s1) {

    }


    public int getIdimagen() {
        return idimagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPila() {
        return pila;
    }

    public String getFecha() {
        return fecha;
    }
}
