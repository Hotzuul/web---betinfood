/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Repositorios;

import com.example.ProyectoBD.Clases.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface IProducto extends CrudRepository<Producto, Integer>{
    
    //Aqui pueden ir consultas a BD adicionales
    @Query(value="SELECT * FROM producto", nativeQuery = true)
    List<Producto> buscarPorTodo(String desc);
}
