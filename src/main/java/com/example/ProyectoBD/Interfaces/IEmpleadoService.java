/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Interfaces;

import com.example.ProyectoBD.Clases.Empleado;
import java.util.List;
import java.util.Optional;


public interface IEmpleadoService {
    
    public List<Empleado> Listar();
    public Optional<Empleado> ConsultarId(int id);
    public void Guardar(Empleado e);
    public void Eliminar(int id);
    public List<Empleado> BuscarAll(String desc);
}
