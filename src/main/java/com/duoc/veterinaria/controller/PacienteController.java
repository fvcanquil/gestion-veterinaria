package com.duoc.veterinaria.controller;

import com.duoc.veterinaria.model.Paciente;
import com.duoc.veterinaria.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    // GET /pacientes → muestra la lista
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "pacientes/listar";
    }

    // GET /pacientes/nuevo → muestra el formulario vacío
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/registrar";
    }

    // POST /pacientes/registrar → guarda el nuevo paciente
    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Paciente paciente) {
        pacienteService.registrar(paciente);
        return "redirect:/pacientes";
    }   
}
