package test;
import java.util.List;
import SuperMercadoSistema.Empleado;
import SuperMercadoSistema.Producto;
import SuperMercadoSistema.SuperMercadoService;
import SuperMercadoSistema.Cliente;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class testMain {
    public static void main(String[] args) {
        //Crear mapas
        Map<Integer, Empleado> empleados = new HashMap<>();
        //agregar empleados
        empleados.put(001,new Empleado(001, "Erick", "Caja"));
        empleados.put(002,new Empleado(002, "Manuel", "Bodega"));
        empleados.put(003,new Empleado(003, "Mabel", "Piso"));
        empleados.put(004,new Empleado(004, "Ricardo", "Piso"));
        
        //Cliente
        Map<Integer, Cliente> clientes = new HashMap<>();
        //agregar clientes
        clientes.put(101, new Cliente("Federico", 101, "Normal"));
        clientes.put(102, new Cliente("Jose", 102, "VIP"));
        clientes.put(103, new Cliente("Miranda", 103, "Normal"));
        clientes.put(104, new Cliente("Flor", 104, "VIP"));
        
        //Productos
        Map<Integer, Producto> productos = new HashMap<>();
        productos.put(1101, new Producto(1101, "Mayonesa", 25D, 15));
        productos.put(1102, new Producto(1102, "Knor", 10D, 20));
        productos.put(1103, new Producto(1103, "Azucar", 23D, 25));
        productos.put(1104, new Producto(1104, "Shampoo", 60D, 15));
        productos.put(1105, new Producto(1105, "Nescafe", 32D, 10));
        productos.put(1106, new Producto(1106, "Frijol", 19D, 15));
        productos.put(1107, new Producto(1107, "Panque", 21.5, 1));

        // --- PRUEBAS ---
        System.out.println("\n1) Productos con stock bajo:");
        productos.values().stream().filter(SuperMercadoService.stockBajo)
        .forEach(p -> System.out.println(p.getProd() + " stock=" + p.getStock()));

        System.out.println("\n2) Total de venta:");
        List<Producto> carrito = Arrays.asList(productos.get(1101), productos.get(1105), productos.get(1104));
        double total = SuperMercadoService.totalVenta.apply(carrito);
        System.out.println("Total: $" + total);

        System.out.println("\n3) Detalles de venta:");
        SuperMercadoService.imprimirVenta.accept(carrito);

        System.out.println("\n4) Producto de muestra:");
        System.out.println(SuperMercadoService.productoMuestra.get());

        System.out.println("\n5) Aplicar descuento:");
        System.out.println(SuperMercadoService.descuento.apply(productos.get(1101)));

        System.out.println("\n6) Producto más caro:");
        System.out.println(SuperMercadoService.masCaro.apply(productos.get(1101), productos.get(1104)));

        System.out.println("\n7) Cliente VIP con compra >1000:");
        System.out.println(SuperMercadoService.puedeDescuento.test(clientes.get(102), 1200.0));

        System.out.println("\n8) Ticket:");
        System.out.println(SuperMercadoService.ticket.apply(clientes.get(104), carrito));

        System.out.println("\n9) Notificación:");
        SuperMercadoService.notificar.accept(clientes.get(101), empleados.get(1));
    }
}

    


