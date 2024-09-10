/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="detallecompra")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int cantidad;
    private Double precio;
    private Double total;
    
    @ManyToOne()
    @JoinColumn(name="compra_id")
    private Compra compra;
    
    @ManyToOne()
    @JoinColumn(name="producto_id")
    private Producto producto;
}
