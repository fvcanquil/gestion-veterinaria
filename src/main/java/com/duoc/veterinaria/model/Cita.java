package com.duoc.veterinaria.model;

/**
 * MODELO - Representa una cita médica en la veterinaria.
 * Campos requeridos por la actividad:
 * fecha, hora, motivo, veterinario asignado y paciente.
 */
public class Cita {

    private Long id;
    private String fechaHora;       
    private String motivo;          
    private String veterinario;     
    private String nombrePaciente;  

    // Constructor vacío 
    public Cita() {}

    // Constructor completo
    public Cita(Long id, String fechaHora, String motivo, String veterinario, String nombrePaciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.veterinario = veterinario;
        this.nombrePaciente = nombrePaciente;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getVeterinario() { return veterinario; }
    public void setVeterinario(String veterinario) { this.veterinario = veterinario; }

    public String getNombrePaciente() { return nombrePaciente; }
    public void setNombrePaciente(String nombrePaciente) { this.nombrePaciente = nombrePaciente; }
}