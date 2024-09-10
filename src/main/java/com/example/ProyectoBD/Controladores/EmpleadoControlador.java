/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Controladores;


import com.example.ProyectoBD.Clases.Empleado;
import com.example.ProyectoBD.Interfaces.IEmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/empleado/")  //localhost/cliente/
@Controller
public class EmpleadoControlador {
    
    String carpeta="Empleado/";
    
    @Autowired
    private IEmpleadoService service;
    
    @GetMapping("/") //localhost/cliente/
    public String Mostrar(Model model)
    {
        List<Empleado> empleados = service.Listar();
        model.addAttribute("empleados", empleados);
        return carpeta + "listaEmpleados"; //listaClientes.html
    }
    
    @GetMapping("/nuevo")
    public String Nuevo()
    {
        return carpeta + "nuevoEmpleado";
    }
    
    @PostMapping("/registrarEmpleado")
    public String Registrar(@RequestParam("nom") String nom,
                            @RequestParam("ape") String ape,
                            @RequestParam("cel") String cel,
                            @RequestParam("esp") String espe,
                            Model model)
    {
        Empleado emp = new Empleado();
        
        emp.setNombre(nom);
        emp.setApellido(ape);
        emp.setCelular(cel);
        emp.setEspecialidad(espe);
        
        
        service.Guardar(emp);
        
        return Mostrar(model);
    }
    
    @GetMapping("/eliminar")
    public String Eliminar(@RequestParam("id") int id,
                            Model model)
    {
        service.Eliminar(id);
        
        return Mostrar(model);
    }
    
}
