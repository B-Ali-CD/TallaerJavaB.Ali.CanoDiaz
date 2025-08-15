package ciclos;

import java.util.Scanner;

public class MenuRestaurante {
    public static void main(String[] args) { 
        Scanner sc= new Scanner(System.in);
        int opcion = 0;
        double precio = 0;
        double sumaTotal = 0;
        int cantidadPedidos = 0;
        do{
            System.out.println("=====Registradora=====");
            System.out.println("1.- Registar Pedido");
            System.out.println("2.- Mostrar total de ventas");
            System.out.println("3.- Salir del sistema");
            System.out.print(": ");
            opcion = sc.nextInt();


            switch (opcion) {
                case 1 -> {
                    System.out.println("=== Registro de pedido ===");
                    System.out.print("Precio: ");
                    precio = sc.nextDouble();
                    if (precio > 0) {
                        sumaTotal += precio;
                        cantidadPedidos++;
                        System.out.println("Pedido registrado correctamente.");
                    } else {
                        System.out.println("El precio debe ser mayor a 0.");
                    }
                }
                case 2 -> {
                    System.out.println("=== Total de ventas ===");
                    System.out.println("Cantidad de pedidos: " + cantidadPedidos);
                    System.out.println("Suma total: $" + sumaTotal);
                }
                case 3 -> {
                    System.out.println("Has salido del sistema. ¡Gracias!");
                }
                default -> {
                    if (opcion < 1 || opcion > 3) {
                        System.out.println("Valor no válido, intenta nuevamente");
                    }
                }
            }

            System.out.println(); // Espacio entre iteraciones
        } while (opcion != 3);

        sc.close();
    }
}
