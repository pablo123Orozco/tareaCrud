/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro.crud.service;

import com.registro.crud.model.Persona;
import com.registro.crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author Pablo
 */
@Service
public class PersonaService {
      @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> listarTodas() {
        return personaRepository.findAll();
    }

    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona obtenerPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        personaRepository.deleteById(id);
    }
}
