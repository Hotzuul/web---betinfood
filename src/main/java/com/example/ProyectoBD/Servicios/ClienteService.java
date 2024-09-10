/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Servicios;

import com.example.ProyectoBD.Clases.Cliente;
import com.example.ProyectoBD.Interfaces.IClienteService;
import com.example.ProyectoBD.Repositorios.ICliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ICliente data;
    
    @Override
    public List<Cliente> Listar() {
        return (List<Cliente>) data.findAll();
    }

    @Override
    public Optional<Cliente> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Cliente cl) {
        data.save(cl);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Cliente> BuscarAll(String desc) {
        return data.buscarPorTodo(desc);
    }
    
}
