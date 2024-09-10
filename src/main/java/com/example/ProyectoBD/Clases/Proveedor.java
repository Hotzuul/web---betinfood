/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String razon_social;
    private String ruc;
    private String celular;
    private String email;
    private String direccion;
}
