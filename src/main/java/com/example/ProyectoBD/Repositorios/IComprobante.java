/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Repositorios;

import com.example.ProyectoBD.Clases.Comprobante;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComprobante extends CrudRepository<Comprobante, Integer>{
    
    @Query(value = "SELECT * FROM comprobante "
            + "WHERE nombre LIKE %?1% "
            + "OR descripcion LIKE %?1%",nativeQuery=true)

            List<Comprobante> buscarPorTodo(String desc);
}