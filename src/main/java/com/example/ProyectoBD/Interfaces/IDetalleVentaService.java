/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Interfaces;

import com.example.ProyectoBD.Clases.DetalleVenta;
import java.util.List;
import java.util.Optional;


public interface IDetalleVentaService {
    
    public List<DetalleVenta> Listar();
    public Optional<DetalleVenta> ConsultarId(int id);
    public void Guardar(DetalleVenta dv);
    public void Eliminar(int id);
    public List<DetalleVenta> BuscarAll(String desc);
    public List<DetalleVenta> BuscarPorIdVenta(int id);
    public int CantidadVentasProducto(int id);
}
