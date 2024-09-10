/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Interfaces;

import com.example.ProyectoBD.Clases.Cliente;
import java.util.List;
import java.util.Optional;


public interface IClienteService {
    
    public List<Cliente> Listar();
    public Optional<Cliente> ConsultarId(int id);
    public void Guardar(Cliente cl);
    public void Eliminar(int id);
    public List<Cliente> BuscarAll(String desc);

}
