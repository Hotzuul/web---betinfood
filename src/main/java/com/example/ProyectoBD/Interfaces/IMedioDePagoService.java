/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Interfaces;

import com.example.ProyectoBD.Clases.MedioDePago;
import java.util.List;
import java.util.Optional;

public interface IMedioDePagoService {
    public List<MedioDePago> Listar();
    public Optional<MedioDePago> ConsultarCodigo(int id);
    public void Guardar(MedioDePago m);
    public void Eliminar(int id);
}