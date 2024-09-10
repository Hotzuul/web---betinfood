/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Repositorios;

import com.example.ProyectoBD.Clases.Proveedor;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface IProveedor extends CrudRepository<Proveedor, Integer>{
    
    //Aqui pueden ir consultas a BD adicionales
    @Query(value="SELECT * FROM proveedor", nativeQuery = true)
    List<Proveedor> buscarPorTodo(String desc);
    
}
