/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Repositorios;

import com.example.ProyectoBD.Clases.Compra;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompra extends CrudRepository<Compra, Integer> {
    
    //Aqui pueden ir consultas a BD adicionales
    @Query(value="SELECT * FROM compra", nativeQuery = true)
    List<Compra> buscarPorTodo(String desc);
    
    // Para obtener el último ID de la venta registrado
    @Query(value="SELECT id FROM compra "
            + "ORDER BY id DESC "
            + "LIMIT 1", nativeQuery = true)
    public int ConsultarIdCompra();
}
