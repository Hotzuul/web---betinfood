/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Servicios;

import com.example.ProyectoBD.Clases.MedioDePago;
import com.example.ProyectoBD.Interfaces.IMedioDePagoService;
import com.example.ProyectoBD.Repositorios.IMedioDePago;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedioDePagoService implements IMedioDePagoService{
    @Autowired
    private IMedioDePago data;
    
    @Override
    public List<MedioDePago> Listar() {
        return (List<MedioDePago>) data.findAll();
    }

    @Override
    public Optional<MedioDePago> ConsultarCodigo(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(MedioDePago m) {
        data.save(m);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }
}