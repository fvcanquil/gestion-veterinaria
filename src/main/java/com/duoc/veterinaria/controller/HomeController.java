package com.duoc.veterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal para la aplicación de Gestión Veterinaria
 * Cumple con el patrón MVC de la arquitectura de 3 capas
 */
@Controller
public class HomeController {

    /**
     * Página de inicio pública
     * Accesible sin autenticación según configuración de seguridad
     */
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("name", "Gestión Veterinaria");
        return "home";
    }

    /**
     * Página de login personalizada
     * Gestionada por Spring Security pero renderizada por este controlador
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}