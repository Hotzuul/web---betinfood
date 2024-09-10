/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Servicios;

import com.example.ProyectoBD.Clases.Proveedor;
import com.example.ProyectoBD.Interfaces.IProveedorService;
import com.example.ProyectoBD.Repositorios.IProveedor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService implements IProveedorService{
    
    @Autowired
    private IProveedor data;
    
    @Override
    public List<Proveedor> Listar() {
        return (List<Proveedor>) data.findAll();
    }

    @Override
    public Optional<Proveedor> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Proveedor pr) {
        data.save(pr);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }
    
    @Override
    public List<Proveedor> BuscarAll(String desc) {
        return data.buscarPorTodo(desc);
    }
}
