package com.duoc.veterinaria.controller;

import com.duoc.veterinaria.model.Cita;
import com.duoc.veterinaria.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * CONTROLADOR - Maneja las rutas de citas médicas.
 * Rutas PRIVADAS: protegidas por Spring Security en WebSecurityConfig.
 */
@Controller
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    // GET /citas → muestra lista de citas
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("citas", citaService.listarTodas());
        return "citas/listar";
    }

    // GET /citas/nueva → muestra formulario vacío
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cita", new Cita());
        return "citas/agendar";
    }

    // POST /citas/agendar → guarda la nueva cita
    @PostMapping("/agendar")
    public String agendar(@ModelAttribute Cita cita) {
        citaService.agendar(cita);
        return "redirect:/citas";
    }
}