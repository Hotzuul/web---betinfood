/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Controladores;

import com.example.ProyectoBD.Clases.MedioDePago;
import com.example.ProyectoBD.Clases.Producto;
import com.example.ProyectoBD.Clases.ReporteC;
import com.example.ProyectoBD.Interfaces.IDetalleCompraService;
import com.example.ProyectoBD.Interfaces.IDetalleVentaService;
import com.example.ProyectoBD.Interfaces.IMedioDePagoService;
import com.example.ProyectoBD.Interfaces.IProductoService;
import com.example.ProyectoBD.Repositorios.IMedioDePago;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reportec") //localhost/reporte/
@Controller
public class ReporteControlador {
    
    String carpeta = "Reporte/";
    
    @Autowired
    private IProductoService service;
    @Autowired
    private IDetalleVentaService service_dv;
    @Autowired
    private IDetalleCompraService service_dc;
    
    @Autowired
    private IMedioDePagoService service_mp;
    
    @GetMapping("/listaReporteC") //localhost/reporte/kardex
    public String Reporte(Model model)
    {   
        ArrayList<ReporteC> reportec = new ArrayList();
        
        String producto="";
        int ingresos = 0;
        int salidas = 0;
        int stock = 0;
        
        List<Producto> productos = service.Listar();
        for (int i = 0; i < productos.size(); i++) {
            
            int id = productos.get(i).getId();
            producto =  productos.get(i).getNombre();
            ingresos = service_dc.CantidadComprasProducto(id);
            salidas = service_dv.CantidadVentasProducto(id);
            stock = ingresos - salidas;
            
            ReporteC rc = new ReporteC();
            rc.setProducto(producto);
            rc.setIngresos(ingresos);
            rc.setSalidas(salidas);
            rc.setStock(stock);
            
            reportec.add(rc);
        }
        

        model.addAttribute("reportec", reportec);  
        return carpeta+"listaReporteC"; //kardex.html
    }
    
    /*
    @PostMapping("/kardex/buscar") //localhost/reporte/kardex/buscar
    public String BuscarKardex(@RequestParam("desc") String desc,
                         Model model)
    {
      List<Producto> productos =  service.Buscar(desc);
      model.addAttribute("productos", productos);
      return carpeta+"listaProductos"; //listaProductos.html
    }
    */
    
}
