/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Interfaces;

import com.example.ProyectoBD.Clases.Compra;
import java.util.List;
import java.util.Optional;


public interface ICompraService {
    
    public List<Compra> Listar();
    public Optional<Compra> ConsultarId(int id);
    public void Guardar(Compra c);
    public void Eliminar(int id);
    public List<Compra> BuscarAll(String desc);
    public int UltimoIdCompra();
}