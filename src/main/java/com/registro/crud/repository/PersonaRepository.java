/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.registro.crud.repository;

import com.registro.crud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Pablo
 */
public interface PersonaRepository extends JpaRepository <Persona, Long> {
    
}
