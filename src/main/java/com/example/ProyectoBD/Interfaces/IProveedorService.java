/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Interfaces;

import com.example.ProyectoBD.Clases.Proveedor;
import java.util.List;
import java.util.Optional;


public interface IProveedorService {
    
    public List<Proveedor> Listar();
    public Optional<Proveedor> ConsultarId(int id);
    public void Guardar(Proveedor pr);
    public void Eliminar(int id);
    public List<Proveedor> BuscarAll(String desc);

}
