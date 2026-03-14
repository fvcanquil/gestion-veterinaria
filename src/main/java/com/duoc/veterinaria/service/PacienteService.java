package com.duoc.veterinaria.service;

import com.duoc.veterinaria.model.Paciente;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

public class PacienteService {
    // Lista en memoria que actúa como "base de datos"
    private List<Paciente> pacientes = new ArrayList<>();
    private Long contadorId = 1L;

    // Constructor: carga pacientes de ejemplo al iniciar
    public PacienteService() {
        pacientes.add(new Paciente(contadorId++, "Firulais", "Perro", "Labrador", 3, "Juan Pérez"));
        pacientes.add(new Paciente(contadorId++, "Michi", "Gato", "Siamés", 2, "María González"));
        pacientes.add(new Paciente(contadorId++, "Toby", "Perro", "Poodle", 5, "Carlos Rojas"));
    }

    // Retorna todos los pacientes
    public List<Paciente> listarTodos() {
        return pacientes;
    }

    // Agrega un nuevo paciente
    public void registrar(Paciente paciente) {
        paciente.setId(contadorId++);
        pacientes.add(paciente);
    }    
}
