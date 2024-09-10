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
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="venta")
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private Date fecha;
    
    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
    @ManyToOne()
    @JoinColumn(name="comprobante_id")
    private Comprobante comprobante;
        
    @ManyToOne()
    @JoinColumn(name="mediodepago_id")
    private MedioDePago mediodepago;
}
