package SuperMercadoSistema;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Supplier;
public class SuperMercadoService {

    // 1. Filtrar productos con stock bajo (<5)
public static Predicate<Producto> stockBajo = p -> p.getStock() < 5;

    // 2. Calcular total de una venta (lista de productos)
public static Function<List<Producto>, Double> totalVenta =
lista -> lista.stream().mapToDouble(Producto::getPrecio).sum();

    // 3. Imprimir detalles de una venta
public static Consumer<List<Producto>> imprimirVenta =
lista -> lista.forEach(p -> 
                System.out.println(p.getID() + " | " + p.getProd() + " - $" + p.getPrecio()));

    // 4. Generar un producto de muestra
public static Supplier<Producto> productoMuestra =
        () -> new Producto(9999, "Producto Demo", 0.0, 0);

    // 5. Aplicar descuento del 10% a un producto
public static Function<Producto, Producto> descuento =
            p -> new Producto(p.getID(), p.getProd(), p.getPrecio() * 0.9, p.getStock());

    // 6. Comparar dos productos y devolver el más caro
public static BinaryOperator<Producto> masCaro =
        (p1, p2) -> p1.getPrecio() >= p2.getPrecio() ? p1 : p2;

    // 7. Verificar si cliente accede a descuento (VIP y compra > 1000)
public static BiPredicate<Cliente, Double> puedeDescuento =
        (c, total) -> c.getTipo().equalsIgnoreCase("VIP") && total > 1000;

    // 8. Generar ticket (Cliente + Venta)
public static BiFunction<Cliente, List<Producto>, String> ticket =
        (c, lista) -> {
                double total = lista.stream().mapToDouble(Producto::getPrecio).sum();
                String productos = lista.stream()
                .map(p -> p.getProd() + " $" + p.getPrecio())
                .collect(Collectors.joining(", "));
                return "=== Ticket de Venta ===\n" +
                "Cliente: " + c.getNombre() + "\n" +
                "Productos: " + productos + "\n" +
                "Total: $" + total;
        };

    // 9. Notificar a un cliente que su compra fue procesada por un empleado
public static BiConsumer<Cliente, Empleado> notificar =
        (c, e) -> System.out.println("Estimado " + c.getNombre() +
        ", su compra fue procesada por " + e.getNombre());

        }
