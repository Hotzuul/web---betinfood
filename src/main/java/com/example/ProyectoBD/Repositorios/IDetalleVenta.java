/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ProyectoBD.Repositorios;

import com.example.ProyectoBD.Clases.DetalleVenta;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDetalleVenta extends CrudRepository<DetalleVenta, Integer>{
    
    @Query(value="SELECT * FROM detalleventa", nativeQuery = true)
    public List<DetalleVenta> buscarPorTodo(String desc);
    
    @Query(value = "SELECT * FROM detalleventa "
                  + "WHERE venta_id = ?1",nativeQuery = true)
    public List<DetalleVenta> FindByIdVenta(int id);
    
    //Cantidad total vendida por producto
    @Query(value="SELECT IFNULL(SUM(cantidad),0) as cantidad "
            + "FROM detalleventa "
            + "WHERE producto_id = ?1",nativeQuery=true)
    public int NumberSales(int id);
    
    //Monto total vendido por producto
    @Query(value="SELECT IFNULL(SUM(total),0) as total "
            + "FROM detalleventa "
            + "WHERE producto_id = ?1",nativeQuery=true)
    public Double PriceSales(int id);
}
