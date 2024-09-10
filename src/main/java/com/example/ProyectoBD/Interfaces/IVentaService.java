/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Interfaces;

import com.example.ProyectoBD.Clases.Venta;
import java.util.List;
import java.util.Optional;


public interface IVentaService {
    
    public List<Venta> Listar();
    public Optional<Venta> ConsultarId(int id);
    public void Guardar(Venta v);
    public void Eliminar(int id);
    public List<Venta> BuscarAll(String desc);
    public int UltimoIdVenta();
}
