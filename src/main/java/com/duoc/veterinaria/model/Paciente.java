package com.duoc.veterinaria.model;

/** Modelo: representa un paciente de la veterinaria.
 */

public class Paciente {

    private long id;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String dueno;

    //Contructor vacio
    public Paciente(){}

    //Contructor completo
    public Paciente (Long id, String nombre, String especie, String raza, int edad, String dueno) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza =  raza;
        this.edad = edad;
        this.dueno = dueno;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getDueno() { return dueno; }
    public void setDueno(String dueno) { this.dueno = dueno; }
}