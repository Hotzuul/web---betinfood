/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Servicios;

import com.example.ProyectoBD.Clases.DetalleVenta;
import com.example.ProyectoBD.Interfaces.IDetalleVentaService;
import com.example.ProyectoBD.Repositorios.IDetalleVenta;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaService implements IDetalleVentaService{
    
    @Autowired
    private IDetalleVenta data;
    
    @Override
    public List<DetalleVenta> Listar() {
      return (List<DetalleVenta>) data.findAll();
    }

    @Override
    public Optional<DetalleVenta> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(DetalleVenta dv) {
        data.save(dv);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<DetalleVenta> BuscarAll(String desc) {
        return data.buscarPorTodo(desc);
    }

    @Override
    public List<DetalleVenta> BuscarPorIdVenta(int id) {
        return data.FindByIdVenta(id);
    }

    @Override
    public int CantidadVentasProducto(int id) {
        return data.NumberSales(id);
    }
}
