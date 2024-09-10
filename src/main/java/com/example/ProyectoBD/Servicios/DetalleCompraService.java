/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Servicios;

import com.example.ProyectoBD.Clases.DetalleCompra;
import com.example.ProyectoBD.Interfaces.IDetalleCompraService;
import com.example.ProyectoBD.Repositorios.IDetalleCompra;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleCompraService implements IDetalleCompraService {
    
    @Autowired
    private IDetalleCompra data;

    @Override
    public List<DetalleCompra> Listar() {
        return (List<DetalleCompra>) data.findAll();
    }

    @Override
    public Optional<DetalleCompra> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(DetalleCompra dc) {
        data.save(dc);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<DetalleCompra> BuscarAll(String desc) {
        return data.buscarPorTodo(desc);
    }

    @Override
    public List<DetalleCompra> BuscarPorIdCompra(int id) {
        return data.FindByIdCompra(id);
    }

    @Override
    public int CantidadComprasProducto(int id) {
        return data.NumberGet(id);
    }
}
