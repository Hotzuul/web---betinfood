/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Controladores;


import com.example.ProyectoBD.Clases.Comprobante;
import com.example.ProyectoBD.Interfaces.IComprobanteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/comprobante/") 
@Controller
public class ComprobanteControlador {
    
    String carpeta="Comprobante/";
    
    @Autowired
    private IComprobanteService service;

    @GetMapping("/") 
    public String Mostrar(Model model)
    {
       List<Comprobante> comprobantes = service.Listar();
       model.addAttribute("comprobantes", comprobantes);
       return carpeta + "listaComprobante"; 
    }
    
    @GetMapping("/nuevo")
    public String Nuevo()
    {
        return carpeta + "nuevoComprobante"; 
    }
    
    @PostMapping("/registrarComprobante")
    public String Registrar(@RequestParam("nom") String nom,
                            @RequestParam("des") String des,
                            Model model)
    {
        //Aqui tiene que ir el proceso de registrar
        Comprobante comprobante = new Comprobante();
        
        comprobante.setNombre(nom);
        comprobante.setDescripcion(des);
        
        service.Guardar(comprobante);
        
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
        Optional<Comprobante> comprobante = service.ConsultarId(id);
        model.addAttribute("comprobante", comprobante);
        return carpeta + "editarComprobante"; 
    }
    
    @PostMapping("/actualizar")
    public String Actualizar(@RequestParam("id") int id,
                            @RequestParam("nombre") String nom,
                            @RequestParam("descripcion") String des,
                            Model model)
    {
        //Aqui tiene que ir el proceso de actualizar
        Comprobante comprobante = new Comprobante();
        comprobante.setId(id);
        comprobante.setNombre(nom);
        comprobante.setDescripcion(des);

        
        service.Guardar(comprobante); //Cuando le mandas el ID -> Actualiza
        
        return Mostrar(model);
    }
    
    @PostMapping("/buscar")
    public String Buscar(@RequestParam("desc") String desc,
                         Model model)
    {
        List<Comprobante> comprobantes = service.BuscarAll(desc);
        model.addAttribute("comprobantes", comprobantes);
        return carpeta + "listaComprobante";
    }
}
