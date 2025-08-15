package ciclos;

import java.util.Scanner;

public class Ej2BucleFor {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int nN;
        int numeroMenor = Integer.MAX_VALUE; // Inicializa con un valor muy grande así cualquier número ingresado menor lo reemplazará.
        int numeroMayor = Integer.MIN_VALUE; // Inicializa con un valor muy pequeño así cualquier número ingresado mayor lo reemplazará.
        boolean datoMenor = false; // Para saber si hubo algún número menor a 10
        boolean datoMayor = false; // Para saber si hubo algún número mayor a 10

        System.out.println("== Programa para diferenciar el número mayor, menor o igual a 10 ==");

        for (int k = 1; k <= 10; k++) {
            System.out.print("Introduce 10 números cualquiera, dato-" + k + ": ");
            nN = entrada.nextInt();

            if (nN < 10) { //empieza la comparación del numero menor
                datoMenor = true;
                if (nN < numeroMenor) {
                    numeroMenor = nN;
                }
            } else if (nN > 10) { //empieza la comparación del numero mayor
                datoMayor = true;
                if (nN > numeroMayor) {
                    numeroMayor = nN;
                }
            } else { // nN == 10
                System.out.println("El número " + nN + " es igual a 10");
            }
        }
    //se comprueba que dato fue correcto para imprimir el mensaje correspondiente
        if (datoMenor) {
            System.out.println("El número menor es: " + numeroMenor);
        } else {
            System.out.println("No se ingresó ningún número menor a 10");
        }

        if (datoMayor) {
            System.out.println("El número mayor es: " + numeroMayor);
        } else {
            System.out.println("No se ingresó ningún número mayor a 10");
        }

        entrada.close();
    }
}

