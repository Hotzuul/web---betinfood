/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class Controlador {
    
    @GetMapping("/")
    public String inicio(Model model) {
        return "index";
    }
    
}
