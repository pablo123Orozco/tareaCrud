/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro.crud.controller;

import com.registro.crud.model.Persona;
import com.registro.crud.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Pablo
 */
@Controller
@RequestMapping("/personas")
public class PersonaController {
    
  @Autowired
    private PersonaService personaService;

    @GetMapping
    public String mostrarPaginaInicio(Model model) {
        model.addAttribute("personas", personaService.listarTodas());
        model.addAttribute("persona", new Persona()); // Objeto para el formulario
        return "index"; // Cargamos la misma página para todas las operaciones
    }

    @PostMapping("/guardar")
    public String guardarPersona(Persona persona) {
        personaService.guardar(persona);
        return "redirect:/"; // Redireccionamos a la misma página después de guardar
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.eliminar(id);
        return "redirect:/"; // Redireccionamos a la misma página después de eliminar
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model) {
        model.addAttribute("persona", personaService.obtenerPorId(id));
        model.addAttribute("personas", personaService.listarTodas()); // Lista de personas
        return "index"; // Todo ocurre en la misma página
    }
}
