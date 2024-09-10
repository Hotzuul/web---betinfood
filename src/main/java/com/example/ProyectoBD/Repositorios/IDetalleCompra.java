/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Repositorios;

import com.example.ProyectoBD.Clases.DetalleCompra;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleCompra extends CrudRepository<DetalleCompra, Integer>{
 
    @Query(value="SELECT * FROM detallecompra", nativeQuery = true)
    public List<DetalleCompra> buscarPorTodo(String desc);
    
    @Query(value = "SELECT * FROM detallecompra "
                  + "WHERE compra_id = ?1",nativeQuery = true)
    public List<DetalleCompra> FindByIdCompra(int id);
    
    //Cantidad total comprada por producto
    @Query(value="SELECT IFNULL(SUM(cantidad),0) as cantidad "
            + "FROM detallecompra "
            + "WHERE producto_id = ?1",nativeQuery=true)
    public int NumberGet(int id);
    
    //Monto total comprado por producto
    @Query(value="SELECT IFNULL(SUM(total),0) as total "
            + "FROM detallecompra "
            + "WHERE producto_id = ?1",nativeQuery=true)
    public Double PriceGet(int id);
    
}
