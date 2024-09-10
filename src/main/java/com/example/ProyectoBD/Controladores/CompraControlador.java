/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Controladores;

import com.example.ProyectoBD.Clases.Carrito;
import com.example.ProyectoBD.Clases.Compra;
import com.example.ProyectoBD.Clases.Comprobante;
import com.example.ProyectoBD.Clases.DetalleCompra;
import com.example.ProyectoBD.Clases.MedioDePago;
import com.example.ProyectoBD.Clases.Producto;
import com.example.ProyectoBD.Clases.Proveedor;
import com.example.ProyectoBD.Interfaces.ICompraService;
import com.example.ProyectoBD.Interfaces.IComprobanteService;
import com.example.ProyectoBD.Interfaces.IDetalleCompraService;
import com.example.ProyectoBD.Interfaces.IMedioDePagoService;
import com.example.ProyectoBD.Interfaces.IProductoService;
import com.example.ProyectoBD.Interfaces.IProveedorService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/compra/") //localhost/venta/
@Controller
public class CompraControlador {
    
    String carpeta = "Compra/";
    
    ArrayList<Carrito> carrito_lista = new ArrayList();
    
    @Autowired
    private ICompraService service;
    
    @Autowired
    private IProductoService service_producto;
    
    @Autowired
    private IMedioDePagoService service_mp;
    
    @Autowired
    private IComprobanteService service_tc;
    
    
    @Autowired
    private IProveedorService service_proveedor;

    @Autowired
    private IDetalleCompraService service_dc;
    
    
    @GetMapping("/") //localhost/venta/
    public String Mostrar(Model model)
    {
       List<Compra> compras = service.Listar();
       model.addAttribute("compras", compras);
       return carpeta+"listaCompra"; //listaVentas.html
    }
    
    @GetMapping("/nuevo")
    public String Nuevo(Model model)
    {
        List<Producto> productos = service_producto.Listar();
        List<Proveedor> proveedores = service_proveedor.Listar();
        List<MedioDePago> mediodepagos = service_mp.Listar();
        List<Comprobante> comprobantes = service_tc.Listar();
        
        model.addAttribute("productos", productos);
        //model.addAttribute("clientes", clientes);
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("mediodepagos", mediodepagos);
        model.addAttribute("comprobantes", comprobantes);
        model.addAttribute("carrito_lista", carrito_lista);
        
        return carpeta + "nuevoCompra"; //nuevoVenta.html
    }
    
    @GetMapping("/eliminar")
    public String Eliminar(@RequestParam("id") int id,
                           Model model)
    {
        // Eliminar la venta detalle
        List<DetalleCompra> dc = service_dc.BuscarPorIdCompra(id);
        for (int i = 0; i < dc.size(); i++)
        {
            int id_dc = dc.get(i).getId();
            service_dc.Eliminar(id_dc);
        }
    
        service.Eliminar(id);
        
        return Mostrar(model);
    }

    @PostMapping("/agregar")
    public String Agregar(@RequestParam("producto_id") int producto_id,
                          @RequestParam("cant") int cant,
                          Model model)
    {
        Optional<Producto> producto = service_producto.ConsultarId(producto_id);
        String nom = producto.get().getNombre();
        Double prec = producto.get().getPrecio();
        Double total = prec * cant;
        
        Carrito carrito = new Carrito();
        carrito.setId(producto_id);
        carrito.setNombre(nom);
        carrito.setPrecio(prec);
        carrito.setCantidad(cant);
        carrito.setTotal(total);
        
        carrito_lista.add(carrito);
        
        return Nuevo(model);
        
    } 

    @GetMapping("/eliminarcarrito")
    public String EliminarCarrito(@RequestParam("id") int id,
                                  Model model)
    {
        carrito_lista.remove(id-1);
        
        return Nuevo(model);
    }
    
    @PostMapping("/registrar")
    public String Registrar(@RequestParam("proveedor_id") Proveedor proveedor_id,
            @RequestParam("comprobante_id") Comprobante comprobante_id,
            @RequestParam("mediodepago_id") MedioDePago mediodepago_id,
            @RequestParam("fecha") String fec,
            Model model) throws ParseException {

        //2023-06-12T20:28
        String[] parts = fec.split("T");
        String part1 = parts[0]; // 2023-06-12
        String part2 = parts[1]; // 20:28
        String fec_ = part1 + " " + part2 + ":00";

        SimpleDateFormat formateador_fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fecha = formateador_fecha.parse(fec_);

        // Registro de la compra
        Compra compra = new Compra();

        compra.setProveedor(proveedor_id);
        compra.setComprobante(comprobante_id);
        compra.setMediodepago(mediodepago_id);
        compra.setFecha(fecha);

        service.Guardar(compra);

        // Conocer el ID de la compra
        int id_compra = service.UltimoIdCompra();

        Compra c = new Compra();

        c.setId(id_compra);

        // Registrar Venta Detalle
        for (int i = 0; i < carrito_lista.size(); i++) {
            int id_producto = carrito_lista.get(i).getId();
            Producto p = new Producto();
            p.setId(id_producto);

            int cant = carrito_lista.get(i).getCantidad();
            Double prec = carrito_lista.get(i).getPrecio();
            Double total = carrito_lista.get(i).getTotal();

            DetalleCompra dc = new DetalleCompra();
            dc.setCompra(compra);
            dc.setProducto(p);
            dc.setCantidad(cant);
            dc.setPrecio(prec);
            dc.setTotal(total);

            service_dc.Guardar(dc);
        }

        carrito_lista.clear();

        return Mostrar(model);

    }
    
}