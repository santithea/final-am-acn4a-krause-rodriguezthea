package com.example.parcial_1_am_acn4a_krause_rodriguezthea;

import android.os.Parcel;
public class Producto {
    private String nombre;
    private String descripcion;
    private String imagenUrl;

    public Producto(String nombre, String descripcion, String imagenUrl) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlImagen() {
        return imagenUrl;
    }
    protected Producto(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        imagenUrl = in.readString();
    }

}