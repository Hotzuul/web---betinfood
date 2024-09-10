/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Servicios;

import com.example.ProyectoBD.Clases.Comprobante;
import com.example.ProyectoBD.Interfaces.IComprobanteService;
import com.example.ProyectoBD.Repositorios.IComprobante;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprobanteService implements IComprobanteService{
    
    @Autowired
    private IComprobante data;
    
    @Override
    public List<Comprobante> Listar() {
        return (List<Comprobante>) data.findAll();
    }

    @Override
    public Optional<Comprobante> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Comprobante co) {
        data.save(co);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Comprobante> BuscarAll(String desc) {
        return data.buscarPorTodo(desc);
    }
}
