/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Controladores;

import com.example.ProyectoBD.Clases.Proveedor;
import com.example.ProyectoBD.Interfaces.IProveedorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


    
@RequestMapping("/proveedor/")  //localhost/proveedor/
@Controller
public class ProveedorControlador {
    
    String carpeta="Proveedor/";
    
    @Autowired
    private IProveedorService service;
    
    @GetMapping("/") //localhost/cliente/
    public String Mostrar(Model model)
    {
        List<Proveedor> proveedores = service.Listar();
        model.addAttribute("proveedores", proveedores);
        return carpeta + "listaProveedor"; //listaClientes.html
    }
    
    @GetMapping("/nuevo")
    public String Nuevo()
    {
        return carpeta + "nuevoProveedor";
    }
    
    @PostMapping("/registrarProveedor")
    public String Registrar(@RequestParam("raz_soc") String raz_soc,
                            @RequestParam("ruc") String ruc,
                            @RequestParam("cel") String cel,
                            @RequestParam("email") String email,
                            @RequestParam("dir") String dir,
                            Model model)
    {
        Proveedor proveedor = new Proveedor();
        
        proveedor.setRazon_social(raz_soc);
        proveedor.setRuc(ruc);
        proveedor.setCelular(cel);
        proveedor.setEmail(email);
        proveedor.setDireccion(dir);
        
        service.Guardar(proveedor);
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
        Optional<Proveedor> proveedor = service.ConsultarId(id);
        model.addAttribute("proveedor", proveedor);
        return carpeta + "editarProveedor";
    }
    
    
    @PostMapping("/actualizar")
    public String Actualizar(@RequestParam("id") int id,
                             @RequestParam("razon_social") String raz_soc,
                             @RequestParam("ruc") String ruc,
                             @RequestParam("celular") String cel,
                             @RequestParam("email") String email,
                             @RequestParam("direccion") String dir,
                             Model model)
    {
        Proveedor proveedor = new Proveedor();
        
        proveedor.setId(id);
        proveedor.setRazon_social(raz_soc);
        proveedor.setRuc(ruc);
        proveedor.setCelular(cel);
        proveedor.setEmail(email);
        proveedor.setDireccion(dir);
        
        service.Guardar(proveedor);     
        return Mostrar(model);
    }
    
    
    @PostMapping("/buscar")
    public String Buscar(@RequestParam("desc") String desc,
                         Model model)
    {
        List<Proveedor> proveedores = service.BuscarAll(desc);
        model.addAttribute("proveedores", proveedores);
        return carpeta + "listaProveedor";
    }
}
