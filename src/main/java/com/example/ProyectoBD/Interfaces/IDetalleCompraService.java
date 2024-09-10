/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Interfaces;

import com.example.ProyectoBD.Clases.DetalleCompra;
import java.util.List;
import java.util.Optional;


public interface IDetalleCompraService {
    
    public List<DetalleCompra> Listar();
    public Optional<DetalleCompra> ConsultarId(int id);
    public void Guardar(DetalleCompra dc);
    public void Eliminar(int id);
    public List<DetalleCompra> BuscarAll(String desc);
    public List<DetalleCompra> BuscarPorIdCompra(int id);
    public int CantidadComprasProducto(int id);
}
