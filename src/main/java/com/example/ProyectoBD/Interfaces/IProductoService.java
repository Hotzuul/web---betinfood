/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Interfaces;

import com.example.ProyectoBD.Clases.Producto;
import java.util.List;
import java.util.Optional;


public interface IProductoService {
    
    public List<Producto> Listar();
    public Optional<Producto> ConsultarId(int id);
    public void Guardar(Producto p);
    public void Eliminar(int id);
    public List<Producto> BuscarAll(String desc);
}
