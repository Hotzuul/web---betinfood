/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Servicios;

import com.example.ProyectoBD.Clases.Venta;
import com.example.ProyectoBD.Interfaces.IVentaService;
import com.example.ProyectoBD.Repositorios.IVenta;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired
    private IVenta data;
    
    @Override
    public List<Venta> Listar() {
      return (List<Venta>) data.findAll();
    }

    @Override
    public Optional<Venta> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Venta v) {
        data.save(v);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Venta> BuscarAll(String desc) {
        return data.buscarPorTodo(desc);
    }

    @Override
    public int UltimoIdVenta() {
        return data.ConsultarIdVenta();
    }
    
}
