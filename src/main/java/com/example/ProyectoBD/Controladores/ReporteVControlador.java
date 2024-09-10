/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Controladores;


import com.example.ProyectoBD.Clases.Producto;
import com.example.ProyectoBD.Clases.ReporteC;
import com.example.ProyectoBD.Clases.ReporteV;
import com.example.ProyectoBD.Interfaces.IDetalleCompraService;
import com.example.ProyectoBD.Interfaces.IDetalleVentaService;
import com.example.ProyectoBD.Interfaces.IMedioDePagoService;
import com.example.ProyectoBD.Interfaces.IProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reportev") //localhost/reporte/
@Controller
public class ReporteVControlador {
    
    String carpeta = "Reporte/";
    
    @Autowired
    private IProductoService service;
    @Autowired
    private IDetalleVentaService service_dv;
    @Autowired
    private IDetalleCompraService service_dc;
    
    @Autowired
    private IMedioDePagoService service_mp;
    
    @GetMapping("/listaReporteV") //localhost/reporte/kardex
    public String Reporte(Model model)
    {   
        ArrayList<ReporteV> reportev = new ArrayList();
        
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
            
            ReporteV rv = new ReporteV();
            rv.setProducto(producto);
            rv.setIngresos(ingresos);
            rv.setSalidas(salidas);
            rv.setStock(stock);
            
            reportev.add(rv);
        }
        

        model.addAttribute("reportev", reportev);  
        return carpeta+"listaReporteV"; //kardex.html
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
