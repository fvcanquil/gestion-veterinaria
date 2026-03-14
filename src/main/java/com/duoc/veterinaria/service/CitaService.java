package com.duoc.veterinaria.service;

import com.duoc.veterinaria.model.Cita;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * SERVICE - Gestiona el almacenamiento de citas EN MEMORIA.
 * Mismo patrón que PacienteService, sin base de datos.
 */
@Service
public class CitaService {

    private List<Cita> citas = new ArrayList<>();
    private Long contadorId = 1L;

    // Citas de ejemplo al iniciar la app
    public CitaService() {
        citas.add(new Cita(contadorId++, "2025-06-15T10:00", "Control anual",     "Dr. García",  "Firulais"));
        citas.add(new Cita(contadorId++, "2025-06-16T11:30", "Vacunación",        "Dra. López",  "Michi"));
        citas.add(new Cita(contadorId++, "2025-06-17T09:00", "Revisión general",  "Dr. García",  "Toby"));
    }

    // Retorna todas las citas
    public List<Cita> listarTodas() {
        return citas;
    }

    // Agrega una nueva cita
    public void agendar(Cita cita) {
        cita.setId(contadorId++);
        citas.add(cita);
    }
}