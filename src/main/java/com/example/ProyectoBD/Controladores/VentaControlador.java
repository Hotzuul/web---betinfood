/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ProyectoBD.Controladores;

import com.example.ProyectoBD.Clases.Carrito;
import com.example.ProyectoBD.Clases.Cliente;
import com.example.ProyectoBD.Clases.Comprobante;
import com.example.ProyectoBD.Clases.DetalleVenta;
import com.example.ProyectoBD.Clases.MedioDePago;
import com.example.ProyectoBD.Clases.Producto;
import com.example.ProyectoBD.Clases.Venta;
import com.example.ProyectoBD.Interfaces.IClienteService;
import com.example.ProyectoBD.Interfaces.IComprobanteService;
import com.example.ProyectoBD.Interfaces.IDetalleVentaService;
import com.example.ProyectoBD.Interfaces.IMedioDePagoService;
import com.example.ProyectoBD.Interfaces.IProductoService;
import com.example.ProyectoBD.Interfaces.IVentaService;
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

@RequestMapping("/Venta/") //localhost/venta/
@Controller
public class VentaControlador {

    String carpeta = "Venta/";

    ArrayList<Carrito> carrito_lista = new ArrayList();

    @Autowired
    private IVentaService service;

    @Autowired
    private IProductoService service_producto;

    @Autowired
    private IMedioDePagoService service_mp;

    @Autowired
    private IComprobanteService service_tc;

    @Autowired
    private IClienteService service_cliente;

    @Autowired
    private IDetalleVentaService service_dv;

    @GetMapping("/") //localhost/venta/
    public String Mostrar(Model model) {
        List<Venta> ventas = service.Listar();
        model.addAttribute("ventas", ventas);
        return carpeta + "listaVenta"; //listaVentas.html
    }

    @GetMapping("/nuevo")
    public String Nuevo(Model model) {
        List<Producto> productos = service_producto.Listar();
        List<Cliente> clientes = service_cliente.Listar();
        List<MedioDePago> mediodepagos = service_mp.Listar();
        List<Comprobante> comprobantes = service_tc.Listar();

        model.addAttribute("productos", productos);
        model.addAttribute("clientes", clientes);
        model.addAttribute("mediodepagos", mediodepagos);
        model.addAttribute("comprobantes", comprobantes);
        model.addAttribute("carrito_lista", carrito_lista);

        return carpeta + "nuevoVenta"; //nuevoVenta.html
    }

    @GetMapping("/eliminar")
    public String Eliminar(@RequestParam("id") int id,
            Model model) {
        // Eliminar la venta detalle
        List<DetalleVenta> dv = service_dv.BuscarPorIdVenta(id);
        for (int i = 0; i < dv.size(); i++)
        {
            int id_dv = dv.get(i).getId();
            service_dv.Eliminar(id_dv);
        }
        
        
        // Elimina la venta
        service.Eliminar(id);

        return Mostrar(model);
    }

    @PostMapping("/agregar")
    public String Agregar(@RequestParam("producto_id") int producto_id,
            @RequestParam("cant") int cant,
            Model model) {
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
            Model model) {
        carrito_lista.remove(id - 1);

        return Nuevo(model);
    }

    @PostMapping("/registrar")
    public String Registrar(@RequestParam("cliente_id") Cliente cliente_id,
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

        // Registro de la venta
        Venta venta = new Venta();

        venta.setCliente(cliente_id);
        venta.setComprobante(comprobante_id);
        venta.setMediodepago(mediodepago_id);
        venta.setFecha(fecha);

        service.Guardar(venta);

        // Conocer el ID de la venta
        int id_venta = service.UltimoIdVenta();

        Venta v = new Venta();

        v.setId(id_venta);

        // Registrar Venta Detalle
        for (int i = 0; i < carrito_lista.size(); i++) {
            int id_producto = carrito_lista.get(i).getId();
            Producto p = new Producto();
            p.setId(id_producto);

            int cant = carrito_lista.get(i).getCantidad();
            Double prec = carrito_lista.get(i).getPrecio();
            Double total = carrito_lista.get(i).getTotal();

            DetalleVenta dv = new DetalleVenta();
            dv.setVenta(venta);
            dv.setProducto(p);
            dv.setCantidad(cant);
            dv.setPrecio(prec);
            dv.setTotal(total);

            service_dv.Guardar(dv);
        }

        carrito_lista.clear();

        return Mostrar(model);

    }
}
