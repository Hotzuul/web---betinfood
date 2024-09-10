/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Repositorios;

import com.example.ProyectoBD.Clases.Venta;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface IVenta extends CrudRepository<Venta, Integer>{
    
    //Aqui pueden ir consultas a BD adicionales
    @Query(value="SELECT * FROM proveedor", nativeQuery = true)
    List<Venta> buscarPorTodo(String desc);
    
    // Para obtener el último ID de la venta registrado
    @Query(value="SELECT id FROM venta "
            + "ORDER BY id DESC "
            + "LIMIT 1", nativeQuery = true)
    public int ConsultarIdVenta();
}
