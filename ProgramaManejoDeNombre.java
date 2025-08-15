package entradas;

import java.util.Scanner;

public class ProgramaManejoDeNombre {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String nombre1, nombre2, nombre3, nuevoNombre1, nuevoNombre2, nuevoNombre3;

        System.out.print("Nombre 1: ");
        nombre1 = entrada.nextLine();
        System.out.print("Nombre 2: ");
        nombre2 = entrada.nextLine();
        System.out.print("Nombre 3: ");
        nombre3 = entrada.nextLine();

        nuevoNombre1 = nombre1.toUpperCase().charAt(0) + "." + nombre1.substring(nombre1.length()-2);
        System.out.println("Nuevo nombre 1 " + nuevoNombre1);
        nuevoNombre2 = nombre2.toUpperCase().charAt(0) + "." + nombre2.substring(nombre2.length()-2);
        System.out.println("Nuevo nombre 2 " + nuevoNombre2);
        nuevoNombre3 = nombre3.toUpperCase().charAt(0) + "." + nombre3.substring(nombre3.length()-2);
        System.out.println("Nuevo nombre 3 " + nuevoNombre3);
        
        System.out.println(nuevoNombre1+"_" + nuevoNombre2 + "_" + nuevoNombre3);
        entrada.close();
    }
}
