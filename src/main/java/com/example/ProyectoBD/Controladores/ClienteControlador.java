/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Controladores;

import com.example.ProyectoBD.Clases.Cliente;
import com.example.ProyectoBD.Interfaces.IClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/cliente/")  //localhost/cliente/
@Controller
public class ClienteControlador {
    
    String carpeta="Cliente/";
    
    @Autowired
    private IClienteService service;
    
    @GetMapping("/") //localhost/cliente/
    public String Mostrar(Model model)
    {
        List<Cliente> clientes = service.Listar();
        model.addAttribute("clientes", clientes);
        return carpeta + "listaClientes"; //listaClientes.html
    }
    
    @GetMapping("/nuevo")
    public String Nuevo()
    {
        return carpeta + "nuevoCliente";
    }
    
    @PostMapping("/registrarCliente")
    public String Registrar(@RequestParam("nom") String nom,
                            @RequestParam("ape") String ape,
                            @RequestParam("dni") String dni,
                            @RequestParam("cel") String cel,
                            @RequestParam("email") String email,
                            @RequestParam("dir") String dir,
                            Model model)
    {
        Cliente cliente = new Cliente();
        
        cliente.setNombre(nom);
        cliente.setApellido(ape);
        cliente.setDni(dni);
        cliente.setCelular(cel);
        cliente.setEmail(email);
        cliente.setDireccion(dir);
        
        service.Guardar(cliente);
        
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
        Optional<Cliente> cliente = service.ConsultarId(id);
        model.addAttribute("cliente", cliente);
        return carpeta + "editarCliente";
    }
    
    
    @PostMapping("/actualizar")
    public String Actualizar(@RequestParam("id") int id,
                            @RequestParam("nombre") String nom,
                            @RequestParam("apellido") String ape,
                            @RequestParam("dni") String dni,
                            @RequestParam("celular") String cel,
                            @RequestParam("email") String email,
                            @RequestParam("direccion") String dir,
                            Model model)
    {
        Cliente cliente = new Cliente();
        
        cliente.setId(id);
        cliente.setNombre(nom);
        cliente.setApellido(ape);
        cliente.setDni(dni);
        cliente.setCelular(cel);
        cliente.setEmail(email);
        cliente.setDireccion(dir);
        
        service.Guardar(cliente);
        
        return Mostrar(model);
    }
    
    
    @PostMapping("/buscar")
    public String Buscar(@RequestParam("desc") String desc,
                         Model model)
    {
        List<Cliente> clientes = service.BuscarAll(desc);
        model.addAttribute("clientes", clientes);
        return carpeta + "listaClientes";
    }
}
