package ciclos;

import java.util.Scanner;

public class Ej4ManejoDeDatos {
    public static void main(String[] args) { 
        Scanner sc= new Scanner(System.in);
        int opcion=0;
        do{
            System.out.println("=====Menu=====");
            System.out.println("1.- Crear");
            System.out.println("2.- Actualizar");
            System.out.println("3.- Eliminar");
            System.out.println("4.- Listar");
            System.out.println("5.- Salir");
            System.out.print(": ");
            opcion = sc.nextInt();


            switch (opcion) {
                case 1 -> System.out.println("Usuario creado correctamente");
                case 2 -> System.out.println("Usuario actualizado correctamente");
                case 3 -> System.out.println("Usuario eliminado correctamente");
                case 4 -> System.out.println("Lista de usuarios mostrada correctamente");
                case 5 -> System.out.println("Haz salido con éxito");
                default -> System.out.println("Valor no válido, intenta nuevamente");
            }

            System.out.println(); // Línea en blanco para separar iteraciones
        } while (opcion != 5);
            
        sc.close();
        }



}
