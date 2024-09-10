/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Controladores;


import com.example.ProyectoBD.Clases.MedioDePago;
import com.example.ProyectoBD.Interfaces.IMedioDePagoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/mediodepago/") //localhost/cliente/
@Controller
public class MedioDePagoControlador {
    
    String carpeta="MedioDePago/";
    
    @Autowired
    private IMedioDePagoService service;
    
    @GetMapping("/")
    public String Mostrar(Model model)
    {
        List<MedioDePago> mediodepagos=service.Listar();
        model.addAttribute("mediodepagos",mediodepagos);
        return carpeta + "listaMedioDePago"; 
    }
    
    @GetMapping("/nuevo")
    public String Nuevo()
    {
        return carpeta + "nuevoMedioDePago";
    }
    
    @PostMapping("/registrar")
    public String Registrar(@RequestParam("id")int id,
                            @RequestParam("nom")String nom,
                            @RequestParam("desc")String desc,
                            Model model)
            
    {
        MedioDePago Aux=new MedioDePago();
        Aux.setId(id);
        Aux.setNombre(nom);
        Aux.setDescripcion(desc);
        
        service.Guardar(Aux);
        
        return Mostrar(model);
    }
    
    @GetMapping("/eliminar")
    public String Eliminar(@RequestParam("id") int id_Buscado,
                           Model model)
    {
        service.Eliminar(id_Buscado);
        return Mostrar(model);
    }
    
    @GetMapping("/editar")
    public String Editar(@RequestParam("id") int id_Buscado,
                           Model model)
    {
        Optional<MedioDePago> Aux=service.ConsultarCodigo(id_Buscado);
        model.addAttribute("mediodepago",Aux);
        return carpeta + "editarMedioDePago";
    }
    
    @PostMapping("/actualizar")
    public String Actualizar(@RequestParam("id")int id,
                            @RequestParam("nombre")String nom,
                            @RequestParam("descripcion")String desc,
                            Model model)
            
    {
        MedioDePago Aux=new MedioDePago();
        Aux.setId(id);
        Aux.setNombre(nom);
        Aux.setDescripcion(desc);
        
        service.Guardar(Aux);
        
        return Mostrar(model);
    }
    
}
