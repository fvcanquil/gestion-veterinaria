package com.duoc.veterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * CONTROLADOR - Rutas públicas principales.
 * /home y /login son las únicas rutas públicas del sistema.
 */
@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("appName", "Gestión Veterinaria");
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}