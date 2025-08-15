package ciclos;

import java.util.Scanner;

public class Ej1BucleFor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int a;
        int b;
        int re = 0;
        System.out.print("====Multiplicacion de dos números====");
        System.out.print("Introduce un numero positivo o negativo a: ");
        a = entrada.nextInt();
        System.out.print("Introduce un numero positivo o negativo b: ");
        b = entrada.nextInt();
        for(int i=1; i <= Math.abs(b); i++) //Math.abs() obtienen el valor absoluto de la variable dentro del parentesis
        {
        re =re + a;

        }
        if(b < 0){      // si el valor de b es negativo
            re = re-re-re;
        }else if(b < 0 && a < 0){ // en caso de que el valor de a y b sea negativo
            a = Math.abs(a);
            b = Math.abs(b);
        for(int i=1; i <= b; i++)
        {
        re =re + a;

        }
            re = re-re-re;
        }
        System.out.println("Resultado = " + re);
    entrada.close();
    }
    
}