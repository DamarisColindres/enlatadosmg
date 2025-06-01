package com.enlatadosmg.model;

public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String contraseña;

    public Usuario(String id, String nombre, String apellido, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
}
