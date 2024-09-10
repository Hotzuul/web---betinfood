/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Controladores;

import com.example.ProyectoBD.Clases.Producto;
import com.example.ProyectoBD.Interfaces.IProductoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/Producto") //localhost/cliente/
@Controller
public class ProductoControlador {
    
    String carpeta="Producto/";
    
    @Autowired
    private IProductoService service;
    
    @GetMapping("/")
    public String Mostrar(Model model)
    {
        List<Producto> productos=service.Listar();
        model.addAttribute("productos",productos);
        return carpeta + "listaProducto"; 
    }
    
    @GetMapping("/nuevo")
    public String Nuevo()
    {
        return carpeta + "nuevoProducto";
    }
    
    @PostMapping("/registrarProducto")
    public String Registrar(@RequestParam("nom")String nom,
                            @RequestParam("detalle_prod")String detalle_prod,
                            @RequestParam("pre")Double pre,
                            Model model)
            
    {
        Producto Aux = new Producto();

        Aux.setNombre(nom);
        Aux.setDetalle_producto(detalle_prod);
        Aux.setPrecio(pre);
        
        service.Guardar(Aux);
        
        return Mostrar(model);
    }
    
    @GetMapping("/eliminar")
    public String Eliminar(@RequestParam("id") int id,
                           Model model)
    {
        service.Eliminar(id);
        return Mostrar(model);
    }
    
    @GetMapping("/editar")
    public String Editar(@RequestParam("id") int id,
                           Model model)
    {
        Optional<Producto> Aux = service.ConsultarId(id);
        model.addAttribute("producto",Aux);
        return carpeta + "editarProducto";
    }
    
    @PostMapping("/actualizar")
    public String Actualizar(@RequestParam("id")int id,
                            @RequestParam("nombre")String nom,
                            @RequestParam("detalle_producto")String detalle_prod,
                            @RequestParam("precio")Double pre,
                            Model model)
            
    {
        Producto Aux = new Producto();
        
        Aux.setId(id);
        Aux.setNombre(nom);
        Aux.setDetalle_producto(detalle_prod);
        Aux.setPrecio(pre);
        
        service.Guardar(Aux);
        
        return Mostrar(model);
    }
    
    @PostMapping("/buscar")
    public String Buscar(@RequestParam("desc") String desc,
                         Model model)
    {
        List<Producto> productos = service.BuscarAll(desc);
        model.addAttribute("productos", productos);
        return carpeta + "listaProductos";
    }
    
}
