/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Interfaces;

import com.example.ProyectoBD.Clases.Comprobante;
import java.util.List;
import java.util.Optional;

public interface IComprobanteService {
    public List<Comprobante> Listar();
    public Optional<Comprobante> ConsultarId(int id);
    public void Guardar(Comprobante co);
    public void Eliminar(int id);
    public List<Comprobante> BuscarAll(String desc);
}
